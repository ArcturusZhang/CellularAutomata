public class ConwayRule extends Rule {
    public ConwayRule() {
        deadLowerThrehold = 2;
        deadUpperThrehold = 3;
        reviveNumber = 3;
    }

    @Override
    public void applyRuleAt(Grid grid, Neighborlizable coordinate) throws Exception {
        Cell cell = grid.get(coordinate);
        int countOfAliveNeighbors = grid.countOfAliveNeighborsAt(coordinate);
        switch (cell.getCurrentState()) {
            case ALIVE:
                if (countOfAliveNeighbors < deadLowerThrehold || countOfAliveNeighbors > deadUpperThrehold) {
                    cell.changeStateTo(State.DEAD);
                }
                return;
            case DEAD:
                if (countOfAliveNeighbors == reviveNumber) {
                    cell.changeStateTo(State.ALIVE);
                }
                return;
        }
    }
}
