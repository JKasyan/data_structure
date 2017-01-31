package recursion;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by 1 on 1/31/2017.
 */
public class MergeSortingTest {
    @Test
    public void sort() throws Exception {
        int[] a = {1, 3 , 7};
        int[] b = {4, 8 , 20, 30};
        int[] res = MergeSorting.sort(a, b);
        System.out.println(Arrays.toString(res));
    }

}