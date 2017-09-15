import java.util.Random;

public enum State {
    DEAD, ALIVE;
    public static State getRandomState() {
        int num = State.values().length;
        Random random = new Random();
        return State.values()[random.nextInt(num)];
    }
}
