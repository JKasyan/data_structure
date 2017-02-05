package sort;

import linked.collections.LinkedStack;
import linked.collections.Stack;

import java.lang.reflect.Array;
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

    public static <T> void bubbleSortWithComparator(T[] array, Comparator<? super T> comparator) {
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

    public static <T extends Comparable<T>> void mergeSort(Comparable<T>[] array, Class<T> clazz) {
        T[] targetArray = (T[])Array.newInstance(clazz, array.length);
        recMergeSort(targetArray, (T[])array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void recMergeSort(T[] targetArray, T[] array, int lower, int upper) {
        if(lower == upper) {
            return;
        } else {
            int middle = (lower + upper) >> 1;
            recMergeSort(targetArray, array, lower, middle);
            recMergeSort(targetArray, array, middle + 1, upper);
            merge(targetArray, array, lower, middle + 1, upper);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] target, T[] res, int low, int high, int upper) {
        System.out.println(Arrays.toString(target));
        int middle = high - 1;
        int pos = 0;
        while (low <= middle && high <= upper) {
            target[pos++] = res[low].compareTo(res[high]) > 0 ? res[high++] : res[low++];
        }
        while (low <= middle) {
            target[pos++] = res[low++];
        }
        while (high <= upper) {
            target[pos++] = res[high++];
        }
        int n = upper - low  + 1;
        for(pos = 0;pos<n;pos++) {
            res[low + pos] = target[pos];
        }
    }

    private static Stack<Integer> factor(int size) {
        Stack<Integer> stack = new LinkedStack<>();
        int number = 1;
        stack.push(number);
        while (true) {
            number = 3 * number + 1;
            if(number < size) {
                stack.push(number);
            } else {
                break;
            }
        }
        return stack;
    }

    public static <T extends Comparable<T>> void shellSort(T[] array) {
        int h = 1, j;
        T temp;
        while (h <= array.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for(int i = h; i < array.length;i++) {
                temp = array[i];
                j = i;
                while (j > h - 1 && array[j - 1].compareTo(temp) > 0) {
                    array[j] = array[j - h];
                    j -= h;
                }
                array[j] = temp;
            }
            h = (h - 1) / 3;
        }
    }
}
