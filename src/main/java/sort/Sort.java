package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by kasyan on 1/12/17.
 */
public class Sort {

    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        for(int i = array.length - 1; i > 0; i--) {
            for(int j = 0; j < i;j++) {
                int comparing = array[j].compareTo(array[j + 1]);
                if(comparing > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private static <T> void swap(T[] array, int first, int second) {
        T buffer = array[second];
        array[second] = array[first];
        array[first] = buffer;
    }

    public static <T> void bubbleSort(T[] array, Comparator<? super T> comparator) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    public static <T extends Comparable<T>> void selectionSort(T[] array) {
        for(int j = 0;j < array.length - 1;j++) {
            int min = j;
            for(int k = j + 1;k < array.length;k++) {
                if(array[min].compareTo(array[k]) > 0) {
                    min = k;
                }
            }
            if(min != j) {
                swap(array, j, min);
            }
        }
    }

    public static <T extends Comparable<T>> void insertSort(T[] array) {
        for(int i = 1; i < array.length;i++) {
            T temp = array[i];
            for(int j = i; j > 0;j--) {
                if(array[j-1].compareTo(temp) > 0) {
                    swap(array, j-1, j);
                } else {
                    break;
                }
            }
        }
    }
}
