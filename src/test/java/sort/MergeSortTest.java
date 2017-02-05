package sort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by kasyan on 2/3/17.
 */
public class MergeSortTest {
    @Test
    public void sort() throws Exception {
        MergeSort mergeSort = new MergeSort();
        int[] array = new int[] {3, 2, 1, 4};
        mergeSort.sort(array);
        assertArrayEquals(new int[]{1,2,3,4}, array);
    }

}