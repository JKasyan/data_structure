package linked.collections;

/**
 * Created by kasyan on 1/26/17.
 */
public class SortedList<T extends Comparable<T>> {

    private Link first;

    private class Link {
        T value;
        Link next;

        Link(T value) {
            this.value = value;
        }
    }

    public void insert(T value) {
        Link current = first;
        Link prev = null;
        while (current != null) {
            if(current.value.compareTo(value) >= 0) {
                Link newLink = new Link(value);
                if(prev == null) {
                    first = newLink;
                } else {
                    prev.next = newLink;
                }
                newLink.next = current.next;
            }
            prev = current;
            current = current.next;
        }
    }
}
