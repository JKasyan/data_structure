package stack;

import java.util.Objects;

/**
 * Created by kasyan on 1/15/17.
 */
public class JavascriptValidator {

    public static boolean checkFunction(String input) {
        Objects.requireNonNull(input);
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < input.length();i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '[':
                case '{':
                case '(':
                    stack.push(ch);
                    break;
                case ']':
                case '}':
                case ')':
                    if(!stack.isEmpty()) {
                        char prev = stack.pop();
                        if( (ch == ']' && prev != '[') ||
                                (ch == '}' && prev != '{') ||
                                (ch == ')' && prev != '(')) {
                            return false;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }
}
