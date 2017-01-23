package linked.collections;

/**
 * Created by 1 on 1/23/2017.
 */
public class LinkList<T extends Comparable<T>> {

    private Link first;

    class Link {
        T value;
        Link next;

        public Link(T value) {
            this.value = value;
        }
    }

    public void insertFirst(T element) {
        Link link = new Link(element);
        link.next = first;
        first = link;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Link current = first;
        builder.append("LinkList[");
        while (current.next != null) {
            builder.append(current.value).append(", ");
            current = current.next;
        }
        builder.setLength(builder.length() - 2);
        builder.append("]");
        return new String(builder);
    }
}
