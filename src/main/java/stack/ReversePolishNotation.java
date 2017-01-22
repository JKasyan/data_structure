package stack;

import java.util.HashMap;

/**
 * Created by kasyan on 1/21/17.
 */
public class ReversePolishNotation {

    private static final HashMap<Character,Integer> OPERATORS = new HashMap<>();

    static {
        OPERATORS.put('+', 0);
        OPERATORS.put('-', 0);
        OPERATORS.put('*', 1);
        OPERATORS.put('/', 1);
    }

    public static String parseToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(int i = 0;i < infix.length();i++) {
            char el = infix.charAt(i);
            if(el == '(') {
                stack.push(el);
            } else if(el == ')') {
                findParentBracket(stack, result);
            } else if(!OPERATORS.containsKey(el)) {
                result.append(el);
            } else {
                addOperator(el, stack, result);
            }
        }
        System.out.println(stack);
        while (!stack.isEmpty()) {
            char top = stack.pop();
            System.out.println(top);
            result.append(top);
        }
        return new String(result);
    }

    private static void addOperator(char operand, Stack<Character> stack, StringBuilder output) {
        final int priorityNew = OPERATORS.get(operand);
        while (!stack.isEmpty()) {
            char top = stack.pop();
            int priorityTop;
            // + - / *
            if(OPERATORS.containsKey(top)) {
                priorityTop = OPERATORS.get(top);
                if(priorityNew < priorityTop) {
                    output.append(top);
                } else {
                    stack.push(top);
                    break;
                }
            } else if(top == '(') {
                stack.push(top);
                break;
            }
        }
        stack.push(operand);
    }

    private static void findParentBracket(Stack<Character> stack, StringBuilder output) {
        while (!stack.isEmpty()) {
            char top = stack.pop();
            if(top == '(') {
                break;
            } else {
                output.append(top);
            }
        }
    }

    public static Integer calculatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();
        for(int j = 0; j < postfix.length();j++) {
            char element = postfix.charAt(j);
            if(element >= '0' && element <= '9') {
                stack.push(Character.getNumericValue(element));
            } else {
                int number1 = stack.pop();
                int number2 = stack.pop();
                int res = calc(number2, number1, element);
                stack.push(res);
            }
        }
        return stack.pop();
    }

    private static int calc(int num1, int num2, char operation) {
        int res ;
        switch (operation) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '/':
                res = num1 / num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            default:
                res = 0;
        }
        return res;
    }
}
