public class CoordinateSystemSettings {
    private static CoordinateSystemSettings instance = null;
    private NeighborhoodType neighborhoodType = NeighborhoodType.VonNeumann;
    private CyclicType cyclicType = CyclicType.Cyclic;
    private int maxX = 10;
    private int maxY = 10;

    private CoordinateSystemSettings(NeighborhoodType neighborhoodType, CyclicType cyclicType, int maxX, int maxY) {
        this.neighborhoodType = neighborhoodType;
        this.cyclicType = cyclicType;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public static CoordinateSystemSettings getInstance() throws Exception {
        if (instance == null) {
            throw new IllegalAccessException("Settings need initialize before get an instance.");
        }
        return instance;
    }

    public static CoordinateSystemSettings getInstance(NeighborhoodType neighborhoodType, CyclicType cyclicType, int maxX, int maxY) {
        if (instance == null) {
            instance = new CoordinateSystemSettings(neighborhoodType, cyclicType, maxX, maxY);
        }
        return instance;
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
