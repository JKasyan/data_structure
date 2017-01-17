package sort;

import org.junit.Test;

import java.util.Arrays;
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

    @Test
    public void insertSort() throws Exception {
        Integer[] array = randomArrayFactory(100000, 30000);
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

}