import java.awt.*;

public class FilledCell extends Cell<Color> {
    FilledCell(Color[] symbols) {
        super(symbols);
    }
    @Override
    public void changeState() {
        changeStateTo(currentState == State.DEAD ? State.ALIVE : State.DEAD);
    }
}
