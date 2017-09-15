import javax.swing.*;
import java.awt.*;
import java.io.File;

public class CellularAutomata {
    public static void main(String[] args) {
        int maxX = 20;
        int maxY = 20;
        CoordinateSystemSettings.getInstance(NeighborhoodType.Moore, CyclicType.Cyclic, maxX, maxY);
        Color[] symbols = new Color[] {Color.CYAN, Color.RED};
        Grid grid = new Grid(new ConwayRule());
        for (int j = 0; j < maxY; j++) {
            for (int i = 0; i < maxX; i++) {
                Cell cell = new FilledCell(symbols);
                cell.setCurrentState(State.getRandomState());
                grid.put(Coordinate.getInstance(i, j), cell);
            }
        }
        JFrame frame = new CellularAutomataFrame(grid);
    }

    public static void test() {
        int maxX = 20;
        int maxY = 20;
        Character[] symbols = new Character[]{' ', 'o'};
        CoordinateSystemSettings system = CoordinateSystemSettings.getInstance(NeighborhoodType.Moore, CyclicType.Cyclic, maxX, maxY);
        Grid grid = new Grid(new ConwayRule());
        for (int j = 0; j < maxY; j++) {
            for (int i = 0; i < maxX; i++) {
                Cell cell = new CharCell(symbols);
                cell.setCurrentState(State.getRandomState());
                grid.put(Coordinate.getInstance(i, j), cell);
            }
        }
//        grid.get(Coordinate.getInstance(5, 10)).setCurrentState(State.ALIVE);
//        grid.get(Coordinate.getInstance(6, 10)).setCurrentState(State.ALIVE);
//        grid.get(Coordinate.getInstance(6, 9)).setCurrentState(State.ALIVE);
//        grid.get(Coordinate.getInstance(5, 9)).setCurrentState(State.ALIVE);
//        grid.get(Coordinate.getInstance(6, 8)).setCurrentState(State.ALIVE);
//        grid.get(Coordinate.getInstance(5, 8)).setCurrentState(State.ALIVE);
        grid.display();
        int cntMax = 100;
        for (int cnt = 1; cnt < cntMax; cnt++) {
            grid.update();
            grid.display();
        }
    }
}
