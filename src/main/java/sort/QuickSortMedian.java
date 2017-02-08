package sort;

/**
 * Created by kasyan on 2/8/17.
 */
public class QuickSortMedian {

    private Integer[] array;

    public QuickSortMedian(Integer[] array) {
        this.array = array;
    }

    public void sort() {
        recQuickSort(0, array.length - 1);
    }

    private void recQuickSort(int left, int right) {
        int size = right - left + 1;
        if(size <= 10) {
            //manualSort(left, right);
            insertSort(left, right);
        } else {
            int median = median(left, right);
            int partition = partition(left, right, median);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    private int partition(int left, int right, Integer pivot) {

        int leftPtr = left;
        int rightPtr = right - 1;

        while (true) {

            while (array[++leftPtr] < pivot);
            while (array[--rightPtr] > pivot);

            if(leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        swap(leftPtr, right - 1);
        return leftPtr;
    }

    private int median(int left, int right) {
        int center = (left + right) / 2;

        if(array[left] > array[center])
            swap(left, center);

        if(array[left] > array[right])
            swap(left, right);

        if(array[center] > array[right])
            swap(center, right);

        swap(center, right - 1);

        return array[right - 1];
    }

    private void swap(int a, int b) {
        Integer temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private void manualSort(int left, int right) {
        int size = right - left + 1;
        if(size <= 1) {
            return;
        } else if (size == 2) {
            if(array[left] > array[right]) {
                swap(left, right);
            }
        } else {
            if(array[left] > array[right - 1])
                swap(left, right - 1);

            if(array[left] > array[right])
                swap(left, right);

            if(array[right - 1] > array[right])
                swap(right - 1, right);
        }
    }

    private void insertSort(int left, int right) {
        int i, j;
        for(i = left + 1;i < right;i++) {
            Integer temp = array[i];
            j = i;
            while (j > left && array[j - 1] >= temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }
}
