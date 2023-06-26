public class NFATransition {
    private NFAState fromState;
    private NFAState toState;
    private String symbol;
    public NFATransition(NFAState fromState, NFAState toState, String symbol){
        this.fromState = fromState;
        this.toState = toState;
        this.symbol = symbol;
    }
    public NFAState getFromState(){
        return fromState;
    }
    public NFAState getToState(){
        return toState;
    }
    public String getSymbol(){
        return symbol;
    }
    public void setFromState(NFAState fromState){
        this.fromState = fromState;
    }
    public void setToState(NFAState toState){
        this.toState = toState;
    }
    public void setSymbol(String symbol){
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return fromState+
                "=>'" + symbol + '\'' +
                "=>" + toState;
    }
}
