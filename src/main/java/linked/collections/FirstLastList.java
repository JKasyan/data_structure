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

    public void insertLast(T value) {
        Link newLink = new Link(value);
        if(isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public T deleteFirst() {
        T temp = first.value;
        if(first.next == null) {
            last = null;
        }
        first = first.next;
        return temp;
    }
}
