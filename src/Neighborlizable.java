import java.util.ArrayList;

public interface Neighborlizable {
    public Neighborlizable left();

    public Neighborlizable right();

    public Neighborlizable top();

    public Neighborlizable bottom();

    public Neighborlizable leftTop();

    public Neighborlizable leftBottom();

    public Neighborlizable rightTop();

    public Neighborlizable rightBottom();

    public default ArrayList<Neighborlizable> getNeighborhoods() {
        ArrayList<Neighborlizable> list = new ArrayList<>();
        list.add(left());
        list.add(right());
        list.add(top());
        list.add(bottom());
        return list;
    }
}
