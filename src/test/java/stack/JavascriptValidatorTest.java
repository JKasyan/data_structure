package stack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kasyan on 1/15/17.
 */
public class JavascriptValidatorTest {

    @Test
    public void checkSuccessFunction() throws Exception {
        String function = "(d) => console.log(d)";
        boolean result = JavascriptValidator.checkFunction(function);
        assertTrue(result);
    }

    @Test
    public void checkIncorrectFunction() {
        String function = "let fact = (d => d <= 1 ? 1 : d*fact(d-1)";
        boolean result = JavascriptValidator.checkFunction(function);
        assertFalse(result);
    }
}