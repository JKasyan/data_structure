package queue;

/**
 * Created by kasyan on 1/17/17.
 */
public class Queue<T extends Comparable<T>> {

    private final int maxSize;
    private Object[] array;
    private int rear;
    private int front;
    private int nItems;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        array = new Object[maxSize];
        rear = -1;
    }

    public void insert(T t) {
        if(rear == maxSize) {
            rear = -1;
        }
        array[++rear] = t;
        nItems++;
    }

    public T remove() {
        T element = (T)array[front++];
        if(front == maxSize) {
            front = 0;
        }
        nItems--;
        return element;
    }

    public T peekFront() {
        return (T)array[front];
    }

    public boolean isFull() {
        return maxSize == nItems;
    }

    public boolean isEmpty() {
        return nItems == 0;
    }
}
