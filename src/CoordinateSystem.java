public class CoordinateSystem {
    private NeighborhoodType neighborhoodType = NeighborhoodType.VonNeumann;
    private CyclicType cyclicType = CyclicType.Cyclic;
    private int maxX;
    private int maxY;
    public CoordinateSystem(NeighborhoodType neighborhoodType, CyclicType cyclicType, int maxX, int maxY) {
        this.neighborhoodType = neighborhoodType;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public NeighborhoodType getNeighborhoodType() {
        return neighborhoodType;
    }

    public CyclicType getCyclicType() {
        return cyclicType;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }
}
