package linked.collections;

import java.util.Iterator;

/**
 * Created by kasyan on 1/27/17.
 */
public class DoubleLinkedList<T extends Comparable<T>> {

    private Link first;
    private Link last;

    private class Link {
        T value;
        Link next;
        Link prev;

        Link(T value) {
            this.value = value;
        }
    }

    public void insertFirst(T value) {
        Link link = new Link(value);
        if(isEmpty()) {
            last = link;
        } else {
            first.prev = link;
        }
        link.next = first;
        first = link;
    }

    public void insertLast(T value) {
        Link link = new Link(value);
        if(isEmpty()) {
            first = link;
        } else {
            last.next = link;
            link.prev = last;
        }
        last = link;
    }

    public boolean insertAfter(T value) {
        Link link = new Link(value);
        Link current = first;
        while (current.value.compareTo(value) != 0) {
            current = current.next;
            if(current == null) {
                return false;
            }
        }
        if(current == last){
            last = link;
        } else {
            current.next.prev = link;
            link.next = current.next;
        }
        link.prev = current;
        current.next = link;
        return true;
    }

    public T deleteFirst() {
        T temp = first.value;
        if (first.next == null) {
            last = null;
        } else {
            first.next.prev = null;
        }
        first = first.next;
        return temp;
    }

    public T deleteLast() {
        T temp = last.value;
        if(last.prev == null) {
            first = null;
        } else {
            last.prev.next = null;
        }
        last = last.prev;
        return temp;
    }

    public T deleteKey(T key) {
        Link current = first;
        if(first == null) {
            return null;
        }
        while (current != null && !current.value.equals(key)) {
            current = current.next;
        }

        if(current == null) {
            return null;
        }

        if (current == first) {
            first = first.next;
        } else {
            current.prev.next = current.next;
        }

        if(current == last) {
            last = current.prev;
        } else {
            current.next.prev = current.prev;
        }
        return current.value;
    }

    public Boolean isEmpty() {
        return first == null;
    }

    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public String toString() {
        String res = "DoubleLinkedList[";
        Link current = first;
        while (current != null) {
            res += current.value;
            if(current.next != null) {
                res += ", ";
            }
            current = current.next;
        }
        return res + "]";
    }
}
