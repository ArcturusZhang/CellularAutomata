import java.util.ArrayList;

public class CellularAutomata {
    public static void main(String[] args) throws Exception {
        int maxX = 10;
        int maxY = 20;
        Character[] symbols = new Character[] {' ', 'o'};
        CoordinateSystemSettings system = CoordinateSystemSettings.getInstance(NeighborhoodType.Moore, CyclicType.Cyclic, maxX, maxY);
        Grid grid = new Grid(new ConwayRule());
        for (int j = 0; j < maxY; j++) {
            for (int i = 0; i < maxX; i++) {
                grid.put(Coordinate.getInstance(i, j), new CharCell(symbols));
            }
        }
        grid.get(Coordinate.getInstance(5,10)).setCurrentState(State.ALIVE);
        grid.get(Coordinate.getInstance(6,10)).setCurrentState(State.ALIVE);
        grid.get(Coordinate.getInstance(6,9)).setCurrentState(State.ALIVE);
        grid.get(Coordinate.getInstance(5,9)).setCurrentState(State.ALIVE);
        grid.get(Coordinate.getInstance(6,8)).setCurrentState(State.ALIVE);
        grid.get(Coordinate.getInstance(5,8)).setCurrentState(State.ALIVE);
        grid.display();
        System.out.println("-----------------------------");
        grid.update();
        grid.display();
    }
}
