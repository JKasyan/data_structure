package linked.collections;

/**
 * Created by 1 on 1/27/2017.
 */
public enum  Order {

    ASCENDING(-1), DESCENDING(0);

    public final int target;

    Order(int target) {
        this.target = target;
    }
}
