/**
 * Abstract Cell class
 * The base class of all kinds of cells that would be implement into a celluar automaton.
 *
 * @param <T> the class of the content of cells.
 */
public abstract class Cell<T> {
    final T[] symbols;
    State currentState = State.DEAD;
    State nextState;
    T currentSymbol;

    /**
     * Constructor of a cell instance.
     *
     * @param symbols, an array contains all the contents for every state of the cell.
     */
    Cell(T[] symbols) {
        this.symbols = symbols;
        currentSymbol = symbols[currentState.ordinal()];
        nextState = null;
    }

    public State getCurrentState() {
        return currentState;
    }

    /**
     * Directly set currentState to the given value.
     *
     * @param currentState, the given state.
     */
    public void setCurrentState(State currentState) {
        this.currentState = currentState;
        currentSymbol = symbols[currentState.ordinal()];
    }

    public State getNextState() {
        return nextState;
    }

    public T getCurrentSymbol() {
        return currentSymbol;
    }

    public T[] getSymbols() {
        return symbols;
    }

    /**
     * Determines this cell is alive or not.
     *
     * @return true for alive, false for not alive (not necessary to be dead).
     */
    public boolean isAlive() {
        return currentState == State.ALIVE;
    }

    public abstract void changeState();

    /**
     * Change the state of this cell, but this change only takes effect when update() method is invoked.
     *
     * @param state
     */
    public void changeStateTo(State state) {
        this.nextState = state;
    }

    /**
     * To update the cell's state with nextState.
     */
    public void update() {
        if (nextState != null) { // Only update state when nextState is not null, otherwise the state is not changed.
            currentState = nextState;
            currentSymbol = symbols[currentState.ordinal()];
            nextState = null;
        }
    }
}
