package arrays;

/**
 * Created by kasyan on 1/30/17.
 */
public class SortedArray<T extends Comparable<T>> {

    private Comparable[] elements;
    private int size;

    public SortedArray() {
        elements = new Comparable[10];
    }

    public void insert(T t) {
        if (size == 0) {
            add(t, 0);
            return;
        }
        int i = size - 1;
        for(;i != -1;i--){
            if(elements[i].compareTo(t) > 0) {
                elements[i+1] = elements[i];
            } else {
                elements[i+1] = t;
                size++;
                break;
            }
        }
        if(i == -1) {
            add(t, 0);
        }
    }

    private void add(T t, int pos) {
        size++;
        elements[pos] = t;
    }

    public int size() {
        return size;
    }

    public int find(T value) {
        int minIndex = 0;
        int maxIndex = size - 1;
        while (true) {
            int middleIndex = (maxIndex + minIndex) >> 1;
            int comparing = elements[middleIndex].compareTo(value);
            if(comparing == 0) {
                return middleIndex;
            } else if(minIndex > maxIndex) {
                return -1;
            } else {
                if(comparing > 0) {
                    maxIndex = middleIndex - 1;
                } else {
                    minIndex = middleIndex + 1;
                }
            }
        }
    }

    @Override
    public String toString() {
        String res = "SortedArray[";
        for(int i = 0; i < size;i++) {
            res += elements[i];
            if(i != size - 1) {
                res += ", ";
            }
        }
        return res + "]";
    }
}
