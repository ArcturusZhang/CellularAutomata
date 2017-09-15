import java.util.Set;

public interface CelluarAutomataUniverse {
//    public Set<Coordinate> aliveCoordinates();

    public Set<Coordinate> aliveNeighborsAt(Coordinate coordinate) throws Exception;

    public int countOfAliveNeighborsAt(Coordinate coordinate) throws Exception;

    public Cell[][] getCellGrid() throws Exception;

    public void update();
}
