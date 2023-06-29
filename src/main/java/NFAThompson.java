import java.util.ArrayList;
import java.util.Arrays;

public class NFAThompson {
    //create constructor, getter and setters
    private NFAState initialState;
    private NFAState finalState;

    private ArrayList<NFATransition> transitions;

    public NFAThompson() {
        initialState = null;
        finalState = null;
        transitions = new ArrayList<NFATransition>();
    }

    public void setNewInitialState(NFAState initialState) {
        this.initialState = initialState;
    }

    public void setNewFinalState(NFAState finalState) {
        this.finalState = finalState;
    }

    public void setThompsonDetails(NFAState initialState, NFAState finalState, ArrayList<NFATransition> transitions) {
        this.initialState = initialState;
        this.finalState = finalState;
        this.transitions = transitions;
    }

    public void setThompsonDetails(NFAState initialState, NFAState finalState) {
        this.initialState = initialState;
        this.finalState = finalState;
    }

    public NFAState getInitialState() {
        return initialState;
    }

    public ArrayList<NFATransition> getTransitions() {
        return transitions;
    }

    public NFAThompson charEpsilon(String symbol) {
        //create a new initial state and a new final state
        NFAState initialState = new NFAState(true, false);
        NFAState finalState = new NFAState(false, true);
        //create a new transition from the initial state to the final state with the symbol
        NFATransition transition = new NFATransition(initialState, finalState, symbol);
        //add the transition to the initial state
        initialState.addTransition(transition);
        setThompsonDetails(initialState, finalState);
        //create a temporary NFAThompson object to return
        NFAThompson charEpsilonThompson = new NFAThompson();
        charEpsilonThompson.setThompsonDetails(initialState, finalState, new ArrayList<>(Arrays.asList(transition)));
        return charEpsilonThompson;
    }

    public NFAThompson concat (ArrayList<NFAThompson> thompsonGraphs){

        NFAThompson firstThompsonGraph = thompsonGraphs.get(0);
        NFAThompson secondThompsonGraph = thompsonGraphs.get(1);

        //add the transitions of the second thompson graph to the first one
        firstThompsonGraph.finalState.addTransition(secondThompsonGraph.initialState.getStateTransitions());
        //change the initial state of transitions added to the first thompson graph
        firstThompsonGraph.finalState.changeTransitionInitialState();
        firstThompsonGraph.finalState.clearStateStatus();
        secondThompsonGraph.setNewInitialState(firstThompsonGraph.finalState);

        NFAThompson concatThompson = new NFAThompson();
        concatThompson.setNewInitialState(firstThompsonGraph.initialState);
        concatThompson.setNewFinalState(secondThompsonGraph.finalState);
        concatThompson.transitions.addAll(firstThompsonGraph.transitions);
        concatThompson.transitions.addAll(secondThompsonGraph.transitions);

        return concatThompson;
    }

    public NFAThompson union(ArrayList<NFAThompson> thompsonGraphs){
        NFAThompson firstThompsonGraph = thompsonGraphs.get(0);
        NFAThompson secondThompsonGraph = thompsonGraphs.get(1);
        NFAState newInitialState = new NFAState(true, false);
        NFAState newFinalState = new NFAState(false, true);
        //create a new transition from the new initial state to the first thompson graph initial state
        NFATransition transition1 = new NFATransition(newInitialState, firstThompsonGraph.initialState, "epsilon");
        newInitialState.addTransition(transition1);
        //create a new transition from the new initial state to the second thompson graph initial state
        NFATransition transition2 = new NFATransition(newInitialState, secondThompsonGraph.initialState, "epsilon");
        newInitialState.addTransition(transition2);
        //create a new transition from the first thompson graph final state to the new final state
        NFATransition transition3 = new NFATransition(firstThompsonGraph.finalState, newFinalState, "epsilon");
        firstThompsonGraph.finalState.addTransition(transition3);
        //create a new transition from the second thompson graph final state to the new final state
        NFATransition transition4 = new NFATransition(secondThompsonGraph.finalState, newFinalState, "epsilon");
        secondThompsonGraph.finalState.addTransition(transition4);
        NFAThompson unionThompson = new NFAThompson();


        //set the new initial state and the new final state of the new thompson graph and add the transitions
        unionThompson.setThompsonDetails(newInitialState, newFinalState, new ArrayList<>(Arrays.asList(transition1, transition2, transition3, transition4)));
        unionThompson.transitions.addAll(firstThompsonGraph.transitions);
        unionThompson.transitions.addAll(secondThompsonGraph.transitions);
        return unionThompson;
    }

    public NFAThompson kleene(NFAThompson thompsonGraph){;
        NFAState newInitialState = new NFAState(true, false);
        NFAState newFinalState = new NFAState(false, true);
        //create a new transition from the new initial state to the thompson graph initial state
        NFATransition transition1 = new NFATransition(newInitialState, thompsonGraph.initialState, "epsilon");
        newInitialState.addTransition(transition1);
        thompsonGraph.initialState.clearStateStatus();
        //create a new transition from the thompson graph final state to the new final state
        NFATransition transition2 = new NFATransition(thompsonGraph.finalState, newFinalState, "epsilon");
        thompsonGraph.finalState.addTransition(transition2);
        thompsonGraph.finalState.clearStateStatus();
        //create a new transition from the new initial state to the new final state
        NFATransition transition3 = new NFATransition(newInitialState, newFinalState, "epsilon");
        newInitialState.addTransition(transition3);
        //create a new transition from the thompson graph final state to the thompson graph initial state
        NFATransition transition4 = new NFATransition(thompsonGraph.finalState, thompsonGraph.initialState, "epsilon");
        thompsonGraph.finalState.addTransition(transition4);
        NFAThompson kleeneThompson = new NFAThompson();
        //set the new initial state and the new final state of the new thompson graph and add the transitions
        kleeneThompson.initialState = newInitialState;
        kleeneThompson.finalState = newFinalState;
        kleeneThompson.setThompsonDetails(newInitialState, newFinalState, new ArrayList<>(Arrays.asList(transition1, transition2, transition3, transition4)));
        kleeneThompson.transitions.addAll(thompsonGraph.transitions);
        return kleeneThompson;
    }

    //epsilon closure method
    public ArrayList<NFAState> epsilonClosure(NFAState state){
        ArrayList<NFAState> epsilonClosure = new ArrayList<>();
        epsilonClosure.add(state);
        for (NFATransition transition : state.getStateTransitions()) {
            if (transition.getSymbol().equals("epsilon")) {
                epsilonClosure.addAll(epsilonClosure(transition.getToState()));
            }
        }
        return epsilonClosure;
    }


    @Override
    public String toString() {
        return "NFAThompson{" +
                "initialState=" + initialState +
                ", finalState=" + finalState +
                ", transitions: " + transitions +
                '}';
    }
}