package queue;

import java.util.Arrays;

/**
 * Created by kasyan on 1/18/17.
 */
public class PriorityQueue<T extends Comparable<T>> {

    private int maxSize;
    private int size;
    private Object[] elements;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        elements = new Object[maxSize];
    }

    public void insert(T t) {
        if(size == 0) {
            elements[size++] = t;
        } else {
            int i;
            for(i = size - 1;i >= 0;i--) {
                // Ascending
                if(((T)elements[i]).compareTo(t) >= 0) {
                    elements[i+1] = elements[i];
                } else {
                    break;
                }
            }
            elements[i+1] = t;
            size++;
        }
    }

    @Override
    public String toString() {
        return "PriorityQueue[" + Arrays.toString(elements) + "]";
    }
}
