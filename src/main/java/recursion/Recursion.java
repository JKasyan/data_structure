package recursion;

import stack.Stack;

/**
 * Created by kasyan on 1/29/17.
 */
public class Recursion {

    public static int triangle(int number) {
        System.out.println("Enter " + number);
        if(number == 1) {
            System.out.println("Returning 1");
            return 1;
        } else {
            int res = number + triangle(number - 1);
            System.out.println("Returning " + res);
            return res;
        }
    }

    public static int triangleStack(int n) {
        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            stack.push(n--);
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static long pow(int a, int b) {
        return b == 1 ? a : pow(a * a, b >> 1);
    }
}
