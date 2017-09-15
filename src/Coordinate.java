import java.util.ArrayList;
import java.util.List;

/**
 * Coordinate class, describes a position.
 */
public class Coordinate {
    private int x; // x coordinate
    private int y; // y coordinate

    /**
     * Default constructor
     */
    private Coordinate() {
    }

    /**
     * To get an instance of Coordinate class, not for external to use.
     *
     * @param x, the x coordinate
     * @param y, the y coordinate
     * @throws Exception
     */
    private Coordinate(int x, int y) throws Exception {
        initialize(x, y);
    }

    private static int removeNullElements(List<?> list) {
        int cnt = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == null) {
                cnt++;
                list.remove(i);
            }
        }
        return cnt;
    }

    /**
     * The method for external routines to invoke to get an instance of Coordinate class with the given x and y.
     *
     * @param x
     * @param y
     * @return a new Coordinate instance.
     */
    public static Coordinate getInstance(int x, int y) {
        try {
            switch (CoordinateSystemSettings.getInstance().getCyclicType()) {
                case NonCyclic:
                    return new Coordinate(x, y);
                case Cyclic:
                    int maxX = CoordinateSystemSettings.getInstance().getMaxX();
                    int maxY = CoordinateSystemSettings.getInstance().getMaxY();
                    return new Coordinate((x + maxX) % maxX, (y + maxY) % maxY);
                default:
                    return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Initialize a Coordinate instance.
     *
     * @param x, the x coordinate
     * @param y, the y coordinate
     * @throws Exception
     */
    private void initialize(int x, int y) throws Exception {
        this.x = x;
        this.y = y;
        if (x >= CoordinateSystemSettings.getInstance().getMaxX() || x < 0)
            throw new IllegalArgumentException("Coordinate out of range.");
        if (y >= CoordinateSystemSettings.getInstance().getMaxY() || y < 0)
            throw new IllegalArgumentException("Coordinate out of range.");
    }

    public Coordinate left() {
        return getInstance(x - 1, y);
    }

    public Coordinate right() {
        return getInstance(x + 1, y);
    }

    public Coordinate top() {
        return getInstance(x, y + 1);
    }

    public Coordinate bottom() {
        return getInstance(x, y - 1);
    }

    public Coordinate leftTop() {
        return getInstance(x - 1, y + 1);
    }

    public Coordinate leftBottom() {
        return getInstance(x - 1, y - 1);
    }

    public Coordinate rightTop() {
        return getInstance(x + 1, y + 1);
    }

    public Coordinate rightBottom() {
        return getInstance(x + 1, y - 1);
    }

    public ArrayList<Coordinate> getNeighborhoods() throws Exception {
        ArrayList<Coordinate> list = new ArrayList<>();
        switch (CoordinateSystemSettings.getInstance().getNeighborhoodType()) {
            case Moore:
                list.add(left());
                list.add(right());
                list.add(top());
                list.add(bottom());
                list.add(leftTop());
                list.add(leftBottom());
                list.add(rightTop());
                list.add(rightBottom());
                break;
            case VonNeumann:
                list.add(left());
                list.add(right());
                list.add(top());
                list.add(bottom());
                break;
        }
        removeNullElements(list);
        return list;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (object instanceof Coordinate) {
            Coordinate coordinate = (Coordinate) object;
            return (x == coordinate.x) && (y == coordinate.y);
        } else return false;
    }

    @Override
    public int hashCode() {
        return (Integer.valueOf(x).hashCode() << 6) | (Integer.valueOf(y).hashCode());
    }
}
