package recursion;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by 1 on 1/31/2017.
 */
public class MergeSortingTest {
    @Test
    public void sortTest() throws Exception {
        int[] a = {1, 3, 7, 30};
        int[] b = {4, 8, 20};
        int[] res = MergeSorting.merge(a, b);
        System.out.println(Arrays.toString(res));
        assertArrayEquals(new int[]{1, 3, 4, 7, 8, 20, 30}, res);
    }

}