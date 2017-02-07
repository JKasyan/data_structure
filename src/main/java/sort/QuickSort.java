package sort;

/**
 * Created by kasyan on 2/7/17.
 */
public final class QuickSort {

    public static void sort(Integer[] array) {
        recQuickSort(array, 0, array.length - 1);
    }

    private static void recQuickSort(Integer[] array, int left, int right) {
        if(right - left <= 0) {
            return;
        } else {
            Integer pivot = array[right];
            int partition = partition(array, left, right, pivot);
            recQuickSort(array, left, partition - 1);
            recQuickSort(array, partition + 1, right);
        }
    }

    private static int partition(Integer[] array, int left, int right, Integer pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;
        while (true) {
            while (array[++leftPtr] < pivot);
            while (rightPtr > 0 && array[--rightPtr] > pivot);
            if(leftPtr >= rightPtr) {
                break;
            } else {
                swap(array, leftPtr, rightPtr);
            }
        }
        swap(array, leftPtr, right);
        return leftPtr;
    }

    private static void swap(Object[] array, int a, int b) {
        Object temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
