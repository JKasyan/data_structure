package linked.collections;

/**
 * Created by kasyan on 1/23/17.
 */
public class FirstLastList<T extends Comparable<T>> {

    private Link first;
    private Link last;

    private class Link {
        T value;
        Link next;

        Link(T value) {
            this.value = value;
        }
    }

    public void insertFirst(T value) {
        Link newLink = new Link(value);
        newLink.next = first;
        if (isEmpty()) {
            last = newLink;
        }
        first = newLink;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
