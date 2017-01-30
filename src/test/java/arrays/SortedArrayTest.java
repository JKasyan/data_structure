package arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kasyan on 1/30/17.
 */
public class SortedArrayTest {

    @Test
    public void insertTest() throws Exception {
        SortedArray<Integer> array = new SortedArray<>();
        array.insert(20);
        array.insert(-5);
        array.insert(10);
        assertEquals(3, array.size());
        assertEquals("SortedArray[-5, 10, 20]", array.toString());
    }

    @Test
    public void findTest() {
        SortedArray<Long> array = new SortedArray<>();
        array.insert(20L);
        array.insert(-5L);
        array.insert(30L);
        array.insert(40L);
        array.insert(100L);
        array.insert(200L);
        array.insert(201L);
        array.insert(251L);
        int i = array.find(201L);
        assertEquals(6, i);
        int j = array.find(300L);
        assertEquals(-1, j);
        int indexFirstElement = array.find(-5L);
        assertEquals(0, indexFirstElement);
    }

}