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
        int pos = top;
        T topElement = (T)elements[top--];
        elements[pos] = null;
        return topElement;
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Stack[");
        int i = 0;
        Object el = elements[i];
        while (el != null) {
            result.append(el).append(", ");
            el = elements[++i];
        }
        result.setLength(result.length() - 2);
        result.append("]");
        return new String(result);
    }
}
