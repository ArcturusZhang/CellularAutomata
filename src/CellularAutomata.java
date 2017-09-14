import java.util.ArrayList;

public class CellularAutomata {
    public static void main(String[] args) {
        int maxX = 10;
        int maxY = 10;
        CoordinateSystem system = new CoordinateSystem(NeighborhoodType.Moore, CyclicType.Cyclic, maxX, maxY);
        ArrayList<Coordinate> coordinates = new ArrayList<>(maxX * maxY);
        ArrayList<CharCell> cells = new ArrayList<>(maxX * maxY);
        for (int j = 0; j < maxY; j++) {
            for (int i = 0; i < maxX; i++) {
//                coordinates.add(Coordinate.getInstance(system, i, j));
//                cells.add(Coordinate.getInstance(system, i, j));
            }
        }
//        char[][] chars = CharCell.getChars(cells);
//        System.out.println(chars.length);
//        System.out.println(chars[0].length);
        CharCell.drawCharCells(cells);
    }
}
