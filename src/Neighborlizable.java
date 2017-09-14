import java.util.ArrayList;

/**
 * Neighborlizable implement
 * contains a set of methods that returns a coordinate's neighborhood.
 */
public interface Neighborlizable {
    /**
     * Get the left coordinate of the current instance.
     *
     * @return Neighborlizable, the left coordinate of the current instance.
     */
    public Neighborlizable left();

    /**
     * Get the right coordinate of the current instance.
     *
     * @return Neighborlizable, the right coordinate of the current instance.
     */
    public Neighborlizable right();

    /**
     * Get the top coordinate of the current instance.
     *
     * @return Neighborlizable, the top coordinate of the current instance.
     */
    public Neighborlizable top();

    /**
     * Get the bottom coordinate of the current instance.
     *
     * @return Neighborlizable, the bottom coordinate of the current instance.
     */
    public Neighborlizable bottom();

    /**
     * Get the left-top coordinate of the current instance.
     *
     * @return Neighborlizable, the left-top coordinate of the current instance.
     */
    public Neighborlizable leftTop();

    /**
     * Get the left-bottom coordinate of the current instance.
     *
     * @return Neighborlizable, the left-bottom coordinate of the current instance.
     */
    public Neighborlizable leftBottom();

    /**
     * Get the right-top coordinate of the current instance.
     *
     * @return Neighborlizable, the right-top coordinate of the current instance.
     */
    public Neighborlizable rightTop();

    /**
     * Get the right-bottom coordinate of the current instance.
     *
     * @return Neighborlizable, the right-bottom coordinate of the current instance.
     */
    public Neighborlizable rightBottom();

    /**
     * Get an ArrayList contains all the neighborhoods of the current instance.
     *
     * @return ArrayList
     * @throws Exception
     */
    public default ArrayList<Neighborlizable> getNeighborhoods() throws Exception {
        ArrayList<Neighborlizable> list = new ArrayList<>();
        list.add(left());
        list.add(right());
        list.add(top());
        list.add(bottom());
        return list;
    }
}
