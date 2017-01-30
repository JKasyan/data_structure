package linked.collections;

/**
 * Created by kasyan on 1/28/17.
 */
public interface Iterator<E> {

    void reset();
    E nextLink();
    E getCurrent();
    boolean atEnd();
    void insertAfter(E value);
    void insertBefore();
    E deleteCurrent();
}
