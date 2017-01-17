package stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kasyan on 1/15/17.
 */
public class StackTest {

    @Test
    public void ensureSizeStackTest() {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < 1000;i++) {
            stack.push(i);
        }
    }

    @Test
    public void push() throws Exception {
        Stack<Integer> stack = new Stack<>(5);
        stack.push(1);
        Integer peek = stack.peek();
        assertEquals(Integer.valueOf(1), peek);
    }

    @Test
    public void pop() throws Exception {
        Stack<Integer> stack = new Stack<>(5);
        Integer el = 1;
        stack.push(el);
        Integer element = stack.pop();
        assertEquals(el, element);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void popFromEmptyStack() throws Exception {
        Stack<Integer> stack = new Stack<>(1);
        stack.pop();
    }

    @Test
    public void peek() throws Exception {
        Stack<Integer> stack = new Stack<>(5);
        Integer el = 1;
        stack.push(el);
        Integer el1 = stack.peek();
        Integer el2 = stack.pop();
        assertEquals(el1, el2);
    }

    @Test
    public void isFullTest() {
        Stack<Integer> stack = new Stack<>(1);
        stack.push(1);
        assertEquals(true, stack.isFull());
    }

    @Test
    public void isEmptyTest() {
        Stack<Integer> stack = new Stack<>(1);
        assertEquals(true, stack.isEmpty());
    }
}