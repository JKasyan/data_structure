package trees;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kasyan on 2/22/17.
 */
public class Tree234Test {

    @Test
    public void insert() throws Exception {
        Tree234<Integer> tree234 = new Tree234<>();
        tree234.insert(10);
        tree234.insert(5);
        tree234.insert(7);
    }

}