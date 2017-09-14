/**
 * CharCell class represents for a cell using a character to display its state.
 */
public class CharCell extends Cell<Character> {
    /**
     * Constructor of a CharCell instance.
     *
     * @param symbols, an array contains all the characters for every state of the cell.
     */
    protected CharCell(Character[] symbols) {
        super(symbols);
    }

    @Override
    public void changeState() {
        changeStateTo(currentState == State.DEAD ? State.ALIVE : State.DEAD);
    }

    @Override
    public String toString() {
        return String.valueOf(currentSymbol);
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
