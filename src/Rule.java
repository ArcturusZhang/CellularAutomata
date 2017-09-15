public abstract class Rule {
    int deadUpperThrehold;
    int deadLowerThrehold;
    int reviveNumber;

    public abstract void applyRuleAt(Grid grid, Coordinate coordinate) throws Exception;
}
