import java.util.ArrayList;

public class CharCell extends Coordinate {
    private State state = State.DEAD;
    private char symbol = ' ';

    CharCell() {
    }

    public static char[][] getChars(ArrayList<CharCell> charCells) {
        if (charCells.size() == 0) return null;
        int maxX = charCells.get(0).getSystem().getMaxX();
        int maxY = charCells.get(0).getSystem().getMaxY();
        char[][] chars = new char[maxX][];
        for (int i = 0; i < maxX; i++) {
            chars[i] = new char[maxY];
        }
        for (CharCell charCell : charCells) {
            chars[charCell.getX()][charCell.getY()] = charCell.symbol;
        }
        return chars;
    }

    public static void drawCharCells(ArrayList<CharCell> charCells) {
        char[][] chars = getChars(charCells);
        if (chars[0] == null) return;
        for (int i = 0; i < chars.length; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int j = 0; j < chars[0].length; j++) {
                stringBuffer.append(chars[i][j]);
            }
            System.out.println(stringBuffer);
        }
    }

    public State getState() {
        return state;
    }

    public char getSymbol() {
        return symbol;
    }

    public void changeState() {
        switch (state) {
            case ALIVE:
                symbol = 'O';
                state = State.DEAD;
                break;
            case DEAD:
                symbol = ' ';
                state = State.ALIVE;
                break;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
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
