package stack;

/**
 * Created by kasyan on 1/15/17.
 */
public class Stack<T> {

    private Object[] elements;
    private int top;

    public Stack() {
        this(10);
    }

    public Stack(int maxSize) {
        elements = new Object[maxSize];
        top = -1;
    }

    public void push(T element) {
        ensureSize();
        elements[++top] = element;
    }

    private void ensureSize() {
        if(isFull()) {
            int newSize = elements.length << 1;
            Object[] newArray = new Object[newSize];
            System.arraycopy(newArray, 0, elements, 0, elements.length);
            elements = newArray;
        }
    }

    public T pop() {
        return (T)elements[top--];
    }

    public T peek() {
        return (T)elements[top];
    }

    public boolean isFull() {
        return top == elements.length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
