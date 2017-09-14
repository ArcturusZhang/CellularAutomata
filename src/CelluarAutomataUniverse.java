import java.util.Set;

public interface CelluarAutomataUniverse {
//    public Set<Coordinate> aliveCoordinates();

    public Set<Neighborlizable> aliveNeighborsAt(Neighborlizable coordinate) throws Exception;

    public int countOfAliveNeighborsAt(Neighborlizable coordinate) throws Exception;

    public Cell[][] getCellGrid() throws Exception;

    public void update();
}
