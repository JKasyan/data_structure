package stack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kasyan on 1/21/17.
 */
public class ReversePolishNotationTest {

    @Test
    public void infixAPlusBMultiplyC() throws Exception {
        String expression = "A+B*C";
        String postfix = ReversePolishNotation.parseToPostfix(expression);
        assertEquals("ABC*+", postfix);
    }

    @Test
    public void infixAPlusBMinusC() throws Exception {
        String expression = "A+B-C";
        String postfix = ReversePolishNotation.parseToPostfix(expression);
        assertEquals("ABC-+", postfix);
    }

    @Test
    public void bracketsTest1() {
        String expression = "A*(B/(K-F*R))";
        String postfix = ReversePolishNotation.parseToPostfix(expression);
        assertEquals("ABKFR*-/*", postfix);
    }

    @Test
    public void calculatePostfix() {
        String expression = "7*(9/(9-3*2))";
        String postfix = ReversePolishNotation.parseToPostfix(expression);
        assertEquals("79932*-/*", postfix);
        int result = ReversePolishNotation.calculatePostfix(postfix);
        assertEquals(21, result);
    }
}