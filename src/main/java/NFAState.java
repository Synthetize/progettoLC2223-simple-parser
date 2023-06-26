import java.util.ArrayList;

public class NFAState {
    private boolean isFinal;
    private boolean isInitial;
    private ArrayList<NFATransition> stateTransitions;
    private int stateName;

    private static int stateCounter = 0;

    public NFAState(boolean isInitial, boolean isFinal){
        this.stateTransitions = new ArrayList<>();
        this.stateName = stateCounter++;
        this.isInitial = isInitial;
        this.isFinal = isFinal;
    }
    public boolean getIsFinal(){
        return isFinal;
    }
    public boolean getIsInitial(){
        return isInitial;
    }
    public int getStateName(){
        return stateName;
    }
    public ArrayList<NFATransition> getStateTransitions(){
        return stateTransitions;
    }
    public void setIsFinal(boolean isFinal){
        this.isFinal = isFinal;
    }
    public void setIsInitial(boolean isInitial){
        this.isInitial = isInitial;
    }
    public void clearStateStatus(){
        isInitial = false;
        isFinal = false;
    }

    public void addTransition(NFATransition transition){
        stateTransitions.add(transition);
    }

    public void addTransition(ArrayList<NFATransition> transitions){
        stateTransitions.addAll(transitions);
    }

    //quando vengono aggiunte le transizioni di uno stato ad un altro, gli stati delle transizioni rimarranno
    //quelle di prima, quindi bisogna cambiare lo stato di partenza delle transizioni
    //change the initial state of all transitions adde to the graph
    public void changeTransitionInitialState(){
        for(NFATransition transition : stateTransitions){
            if(transition.getFromState().getStateName() != this.getStateName())
                transition.setFromState(this);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(stateName);
    }
}
