package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by kasyan on 1/12/17.
 */
public class Sort {

    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        int compositions = 0;
        int comparisons = 0;
        for(int i = array.length - 1; i > 0; i--) {
            for(int j = 0; j < i;j++) {
                int comparing = array[j].compareTo(array[j + 1]);
                comparisons++;
                if(comparing > 0) {
                    swap(array, j, j + 1);
                    compositions++;
                }
            }
        }
        System.out.println("compositions = " + compositions);
        System.out.println("comparisons = " + comparisons);
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
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i].compareTo(array[j]) > 0) {
                    swap(array, i, j);
                }
            }
        }
        System.out.println(Arrays.toString(array));
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
