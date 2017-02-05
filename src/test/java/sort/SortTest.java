package sort;

import org.junit.Test;
import stack.Stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by kasyan on 1/12/17.
 */
public class SortTest {

    @Test
    public void selectionSort() throws Exception {
        Integer[] array = new Integer[]{3, 20, 8, 1};
        Sort.selectionSort(array);
        assertArrayEquals(new Integer[]{1, 3, 8, 20}, array);
    }

    @Test
    public void bubbleSort() throws Exception {
        Integer[] array = new Integer[]{3, 20, 8, 1};
        Sort.bubbleSort(array);
        assertArrayEquals(new Integer[]{1, 3, 8, 20}, array);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void bubbleSortWithComparatorTest() {
        Comparator<Integer> comparator = (d1, d2) -> d1.compareTo(d2) > 0 ? d1.compareTo(d2) == 0 ? 0 : -1 : 1;
        Sort.bubbleSortWithComparator(new Integer[]{}, comparator);
    }

    @Test
    public void insertSort() throws Exception {
        Integer[] array = randomArrayFactory(5, 20);
        Integer[] copyArray = Arrays.copyOfRange(array, 0, array.length);
        Arrays.sort(copyArray);
        Sort.insertSort(array);
        assertArrayEquals(copyArray, array);
    }

    private Integer[] randomArrayFactory(int maxSize, int maxValue) {
        Random random = new Random();
        Integer[] array = new Integer[maxSize];
        for(int i = 0; i < maxSize; i++) {
            array[i] = random.nextInt(maxValue);
        }
        return array;
    }

    private <T extends Comparable<T>> T[] copyArray(T[] array) {
        return Arrays.copyOfRange(array, 0, array.length);
    }

    //@Test
    public void mergeSortTest() throws Exception {
        Integer[] array = new Integer[]{4, 1, 2, 3};
        Sort.mergeSort(array, Integer.class);
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, array);
    }

    @Test
    public void shellSortTest() {
        Integer[] array = randomArrayFactory(100000, 100000000);
        Integer[] copy = copyArray(array);
        Arrays.sort(copy);
        Sort.shellSort(array);
        assertArrayEquals(copy, array);
    }

}