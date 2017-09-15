import java.util.*;

/**
 * Grid class describes a grid of cells.
 */
public class Grid implements CelluarAutomataUniverse {
    /**
     * Use a HashMap to store the corresponding relationship of a pair of coordinate and cell.
     */
    private Map<Coordinate, Cell> map = new HashMap<>();
    private Rule rule = null;

    Grid() {
    }

    /**
     * Get an instance of grid with the given Rule.
     *
     * @param rule
     */
    Grid(Rule rule) {
        this.rule = rule;
    }

    Grid(Map<Coordinate, Cell> map) {
        this.map = map;
    }

    private static void displayCells(Cell[][] cells) {
        int maxX = cells.length;
        int maxY = cells[0].length;
        for (int i = 0; i < maxX; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int j = 0; j < maxY; j++) {
                stringBuffer.append(cells[i][j]);
            }
            System.out.println(stringBuffer);
        }
    }

    public int getMaxX() {
        try {
            return CoordinateSystemSettings.getInstance().getMaxX();
        } catch (Exception e) {
            return 0;
        }
    }

    public int getMaxY() {
        try {
            return CoordinateSystemSettings.getInstance().getMaxY();
        } catch (Exception e) {
            return 0;
        }
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public Cell put(Coordinate key, Cell value) {
        return map.put(key, value);
    }

    public Cell get(Coordinate key) {
        return map.get(key);
    }

    public Set<Coordinate> keySet() {
        return map.keySet();
    }

    @Override
    public synchronized Set<Coordinate> aliveNeighborsAt(Coordinate coordinate) throws Exception {
        ArrayList<Coordinate> neighborhoods = coordinate.getNeighborhoods();
        Set<Coordinate> coordinateSet = new HashSet<>();
        for (Coordinate neighbor : neighborhoods) {
            if (map.get(neighbor).isAlive()) {
                coordinateSet.add(neighbor);
            }
        }
        return coordinateSet;
    }

    @Override
    public synchronized int countOfAliveNeighborsAt(Coordinate coordinate) throws Exception {
        return aliveNeighborsAt(coordinate).size();
    }

    @Override
    public synchronized Cell[][] getCellGrid() {
        int maxX = getMaxX();
        int maxY = getMaxY();
        Cell[][] cells = new Cell[maxX][];
        for (int i = 0; i < maxX; i++) {
            cells[i] = new Cell[maxY];
            for (int j = 0; j < maxY; j++) {
                cells[i][j] = map.get(Coordinate.getInstance(i, j));
            }
        }
        return cells;
    }

    @Override
    public synchronized void update() {
        Set<Coordinate> coordinates = map.keySet();
        try {
            for (Coordinate coordinate : coordinates) {
                rule.applyRuleAt(this, coordinate);
            }
            for (Coordinate coordinate : coordinates) {
                map.get(coordinate).update();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays the current state of the cellular automaton on console.
     */
    public void display() {
        try {
            displayCells(this.getCellGrid());
            System.out.println("--------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
