import java.util.*;

/**
 * Grid class describes a grid of cells.
 */
public class Grid implements CelluarAutomataUniverse {
    /**
     * Use a HashMap to store the corresponding relationship of a pair of coordinate and cell.
     */
    private Map<Neighborlizable, Cell> map = new HashMap<>();
    private Rule rule = null;

    Grid() {
    }

    /**
     * Get an instance of grid with the given Rule.
     * @param rule
     */
    Grid(Rule rule) {
        this.rule = rule;
    }

    Grid(Map<Neighborlizable, Cell> map) {
        this.map = map;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public Rule getRule() {
        return rule;
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

    public Cell put(Neighborlizable key, Cell value) {
        return map.put(key, value);
    }

    public Cell get(Neighborlizable key) {
        return map.get(key);
    }

    @Override
    public synchronized Set<Neighborlizable> aliveNeighborsAt(Neighborlizable coordinate) throws Exception {
        ArrayList<Neighborlizable> neighborhoods = coordinate.getNeighborhoods();
        Set<Neighborlizable> neighborlizableSet = new HashSet<>();
        for (Neighborlizable neighbor : neighborhoods) {
            if (map.get(neighbor).isAlive()) {
                neighborlizableSet.add(neighbor);
            }
        }
        return neighborlizableSet;
    }

    @Override
    public synchronized int countOfAliveNeighborsAt(Neighborlizable coordinate) throws Exception {
        return aliveNeighborsAt(coordinate).size();
    }

    @Override
    public synchronized Cell[][] getCellGrid() throws Exception {
        int maxX = CoordinateSystemSettings.getInstance().getMaxX();
        int maxY = CoordinateSystemSettings.getInstance().getMaxY();
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
        Set<Neighborlizable> coordinates = map.keySet();
        try {
            for (Neighborlizable coordinate : coordinates) {
                rule.applyRuleAt(this, coordinate);
            }
            for (Neighborlizable coordinate : coordinates) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
