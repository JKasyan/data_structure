package sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by kasyan on 2/8/17.
 */
public class QuickSortMedianTest {
    @Test
    public void sort() throws Exception {
        Integer[] array = descendingArray(1000000);
        QuickSortMedian quickSortMedian = new QuickSortMedian(array);
        quickSortMedian.sort();
    }

    private Integer[] descendingArray(int end) {
        Integer[] array = new Integer[end];
        for(int i = 0; i < end;i++) {
            array[i] = end - i;
        }
        return array;
    }
}