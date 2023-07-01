import java.util.ArrayList;
import java.util.Arrays;

public class stringValidation {
    private String string;
    private NFAThompson thompsonGraph;

    boolean result = false;

    public stringValidation(String string, NFAThompson thompsonGraph) {
        this.thompsonGraph = thompsonGraph;
        this.string = string;
    }

    public void validation() {
        ArrayList<String> toValidate = new ArrayList<>(Arrays.asList(string.split(",")));
        System.out.println("Regexp: " + toValidate.get(0));
        toValidate.remove(0);
        System.out.println("String to validate: " + toValidate);

        ArrayList<String> finalOutput = new ArrayList<>();
        for (String s : toValidate) {
            result = false;
            if(accept(thompsonGraph.epsilonClosure(thompsonGraph.getInitialState()), s, 0)){
                finalOutput.add("OK");
            }else {
                finalOutput.add("KO");
            }
        }
        System.out.println("Final output: " + finalOutput);

    }

    public boolean accept(ArrayList<NFAState> states, String toCheck, Integer charIndex) {

        ArrayList<NFAState> nextStates = new ArrayList<>();
        String charToCheck = String.valueOf(toCheck.charAt(charIndex));
        //se le transizioni dell'attuale closure (states) ha una transizione verso uno o piu con il carattere da controllare
        System.out.println("Char to check: " + charToCheck);
        for (NFAState s : states) {
            for (NFATransition t : s.getStateTransitions()) {
                String symbol = t.getSymbol();
                System.out.println("Symbol: " + symbol);
                if (symbol.equals(charToCheck)) {
                    nextStates.add(t.getToState());
                    System.out.println("match");
                }
            }
        }
        //effettua le closure dei nuovi stati
        System.out.println("Next states: " + nextStates);
        ArrayList<NFAState> nextStatesClosure = new ArrayList<>();
        for (NFAState s : nextStates) {
            nextStatesClosure.addAll(thompsonGraph.epsilonClosure(s));
        }
        //se non ci sono stati successivi e non siamo arrivati alla fine della stringa
        //se next states è vuoi allora la closure saranno vuote
        System.out.println("Next states closure: " + nextStatesClosure);
        if (nextStatesClosure.isEmpty()) {
            if (charIndex != toCheck.length() - 1) {
                result = false;
                return result;
            }
        }
        //chiamo ricorsivamente la funzione
        if ((charIndex + 1) <= toCheck.length() - 1) {
            accept(nextStatesClosure, toCheck, charIndex + 1);
        } else {
            //se siamo arrivati alla fine della stringa, controlliamo se ci sono stati finali
            for (NFAState s : nextStatesClosure) {
                if (s.getIsFinal()) {
                    result = true;
                    return result;
                }
            }
            return result;
        }
        return result;
    }
}



