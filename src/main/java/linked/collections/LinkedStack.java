package linked.collections;

/**
 * Created by kasyan on 2/5/17.
 */
public class LinkedStack<T extends Comparable<T>> implements Stack {

    private LinkList<T> linkList;

    public LinkedStack() {
        this.linkList =  new LinkList<>();
    }

    @Override
    public T pop() {
        return linkList.deleteFirst();
    }

    @Override
    public void push(Object element) {
        linkList.insertFirst((T)element);
    }

    @Override
    public T peek() {
        return linkList.readFirst();
    }

    @Override
    public boolean isEmpty() {
        return linkList.isEmpty();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
