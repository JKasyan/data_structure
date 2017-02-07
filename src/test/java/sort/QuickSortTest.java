package sort;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kasyan on 2/7/17.
 */
public class QuickSortTest {

    @Test
    public void sortTest() throws Exception {
        Integer[] array = new Integer[]{3, 4, 1, 2};
        QuickSort.sort(array);
        assertArrayEquals(new Integer[]{1,2,3,4}, array);
    }

}