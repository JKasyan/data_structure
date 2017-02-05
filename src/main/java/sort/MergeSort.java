package sort;

public class MergeSort {

    private int[] numbers;
    private int[] helper;

    public void sort(int[] array) {
        this.numbers = array;
        helper = new int[array.length];
        mergeSort(0, array.length - 1);
    }

    private void mergeSort(int low, int high) {
        if(low < high) {
            int middle = low + (high - low) / 2;
            mergeSort(low, middle);
            mergeSort(middle + 1, high);
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {
        for(int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }
        int i = low;
        int j = middle + 1;
        int k = low;
        while(i <= middle && j <= high) {
            if(helper[i] <= helper[j]) {
                numbers[k] = helper[i++];
            } else {
                numbers[k] = helper[j++];
            }
            k++;
        }
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }
    }
}
