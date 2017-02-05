package linked.collections;

/**
 * Created by kasyan on 2/5/17.
 */
public interface Stack<T> {

    T pop();
    void push(Object element);
    T peek();
    boolean isEmpty();

}
