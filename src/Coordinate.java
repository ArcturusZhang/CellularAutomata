import java.util.ArrayList;
import java.util.List;

public class Coordinate implements Neighborlizable {
    private CoordinateSystem system = null;
    private int x;
    private int y;

    Coordinate() {
    }

    Coordinate(CoordinateSystem system, int x, int y) {
        initialize(system, x, y);
    }

    public CoordinateSystem getSystem() {
        return system;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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

    private void initialize(CoordinateSystem system, int x, int y) {
        this.system = system;
        this.x = x;
        this.y = y;
        if (x >= system.getMaxX() || x < 0) throw new IllegalArgumentException("Coordinate out of range.");
        if (y >= system.getMaxY() || y < 0) throw new IllegalArgumentException("Coordinate out of range.");
    }

    public static Coordinate getInstance(CoordinateSystem system, int x, int y) {
        try {
            switch (system.getCyclicType()) {
                case NonCyclic:
                    return new Coordinate(system, x, y);
                case Cyclic:
                    int maxX = system.getMaxX();
                    int maxY = system.getMaxY();
                    return new Coordinate(system, (x + maxX) % maxX, (y + maxY) % maxY);
                default:
                    return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Neighborlizable left() {
        return getInstance(system, x - 1, y);
    }

    @Override
    public Neighborlizable right() {
        return getInstance(system, x + 1, y);
    }

    @Override
    public Neighborlizable top() {
        return getInstance(system, x, y + 1);
    }

    @Override
    public Neighborlizable bottom() {
        return getInstance(system, x, y - 1);
    }

    @Override
    public Neighborlizable leftTop() {
        return getInstance(system, x - 1, y + 1);
    }

    @Override
    public Neighborlizable leftBottom() {
        return getInstance(system, x - 1, y - 1);
    }

    @Override
    public Neighborlizable rightTop() {
        return getInstance(system, x + 1, y + 1);
    }

    @Override
    public Neighborlizable rightBottom() {
        return getInstance(system, x + 1, y - 1);
    }

    @Override
    public ArrayList<Neighborlizable> getNeighborhoods() {
        ArrayList<Neighborlizable> list = Neighborlizable.super.getNeighborhoods();
        switch (system.getNeighborhoodType()) {
            case Moore:
                list.add(leftTop());
                list.add(leftBottom());
                list.add(rightTop());
                list.add(rightBottom());
                break;
            case VonNeumann:
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
            return (system == coordinate.system) && (x == coordinate.x) && (y == coordinate.y);
        } else return false;
    }

    @Override
    public int hashCode() {
        return (system.hashCode() << 8) | (Integer.valueOf(x).hashCode() << 4) | (Integer.valueOf(y).hashCode());
    }
}
