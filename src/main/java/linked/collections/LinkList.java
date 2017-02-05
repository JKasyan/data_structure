package linked.collections;

/**
 * Created by 1 on 1/23/2017.
 */
public class LinkList<T extends Comparable<T>> {

    private Link first;

    private class Link {
        T value;
        Link next;

        Link(T value) {
            this.value = value;
        }
    }

    public void insertFirst(T element) {
        Link link = new Link(element);
        link.next = first;
        first = link;
    }

    public T deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp.value;
    }

    public T readFirst() {
        return first.value;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public boolean find(T value) {
        Link current = first;
        while (current != null) {
            if(current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean delete(T value) {
        Link current = first;
        Link previous = null;
        while (current != null) {
            if(current.value.equals(value)) {
                if(previous != null) {
                    previous.next = current.next;
                } else {
                    first = current.next;
                }
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Link current = first;
        builder.append("LinkList[");
        while (current != null) {
            builder.append(current.value).append(", ");
            current = current.next;
        }
        if(!isEmpty()) {
            builder.setLength(builder.length() - 2);
        }
        builder.append("]");
        return new String(builder);
    }
}
