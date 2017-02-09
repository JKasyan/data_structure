package trees;

import org.junit.Test;
import sort.SortTest;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by kasyan on 2/9/17.
 */
public class BinaryTreeTest {
    @Test
    public void find() throws Exception {

    }

    @Test
    public void insertTest() throws Exception {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        SortTest sortTest = new SortTest();
        //Integer[] numbers = sortTest.randomArrayFactory((int)Math.pow(2, 10), 100);
        Integer[] numbers = new Integer[]{5, 2, 7, 3, 4, 8};
        Arrays.stream(numbers).forEach(binaryTree::insert);
        Integer number = binaryTree.find(numbers[numbers.length - 1]);
        assertNotNull(number);
        assertEquals(numbers[numbers.length - 1], number);
    }

}