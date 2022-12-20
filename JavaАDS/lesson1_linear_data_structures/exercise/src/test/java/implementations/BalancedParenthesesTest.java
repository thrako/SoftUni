package implementations;

import org.junit.Test;

import static org.junit.Assert.*;

public class BalancedParenthesesTest {
    @Test
    public void zeroTestOne() {
        String input = "{[()]}";
        Boolean solve = new BalancedParentheses(input).solve();
        assertNotNull(solve);
        assertTrue(solve);
    }

    @Test
    public void zeroTestTwo() {
        String input = "{[(])}";
        Boolean solve = new BalancedParentheses(input).solve();
        assertNotNull(solve);
        assertFalse(solve);
    }
}