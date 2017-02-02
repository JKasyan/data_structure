package recursion;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kasyan on 1/29/17.
 */
public class RecursionTest {
    @Test
    public void triangleTest() throws Exception {
        int triangle = Recursion.triangle(4);
        assertEquals(10 , triangle);
    }

    @Test
    public void triangleStackTest() {
        int res = Recursion.triangleStack(4);
        assertEquals(10, res);
    }

    @Test
    public void powTest() {
        long pow = Recursion.pow(2, 3);
        System.out.println(pow);
    }

}