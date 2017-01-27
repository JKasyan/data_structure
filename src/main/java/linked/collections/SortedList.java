package linked.collections;

/**
 * Created by kasyan on 1/26/17.
 */
public class SortedList<T extends Comparable<T>> {

    private Link first;
    private final Order order;

    private class Link {
        T value;
        Link next;

        Link(T value) {
            this.value = value;
        }
    }

    public SortedList(Order order) {
        this.order = order;
    }

    public SortedList() {
        this(Order.ASCENDING);
    }

    public void insert(T value) {
        Link current = first;
        Link prev = null;
        Link newLink = new Link(value);
        while (current != null && compare(current.value, value)) {
            prev = current;
            current = current.next;
        }
        if(prev == null) {
            first = newLink;
        } else {
            prev.next = newLink;
        }
        newLink.next = current;
    }

    private Boolean compare(T current, T another) {
        int comparing = current.compareTo(another);
        return comparing >> 31 == order.target;
    }

    public T remove() {
        T temp = first.value;
        first = first.next;
        return temp;
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public String toString() {
        String res = "SortedList[";
        Link current = first;
        while (current != null) {
            res += current.value;
            current = current.next;
            if(current != null) {
                res += ", ";
            }
        }
        return res + "]";
    }
}
