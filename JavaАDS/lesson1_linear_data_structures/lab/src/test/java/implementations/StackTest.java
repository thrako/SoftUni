package implementations;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    private Stack<String> stack;

    @Before
    public void setUp() {
        this.stack = new Stack<>();
        for (int i = 0; i < 100; i++) {
            stack.push(String.valueOf(i));
        }
    }

    @Test
    public void testPushShouldAddAtTheTop() {
        stack.push("Slayer");
        assertEquals("Slayer", stack.peek());
    }

    @Test
    public void testPopShouldRemoveAndReturnTopElement() {
        assertEquals("99", stack.pop());
        assertEquals(99, stack.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testPopShouldThrowWhenEmpty() {
        new Stack<>().pop();
    }

    @Test
    public void testPeekShouldReturnAndNotRemove() {
        assertEquals("99", stack.peek());
        assertEquals(100, stack.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testPeekShouldThrowWhenEmpty() {
        new Stack<>().peek();
    }

    @Test
    public void testSizeShouldReturnCorrect() {
        assertEquals(0, new Stack<>().size());
        assertEquals(100, stack.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(new Stack<>().isEmpty());
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testIteratorShouldTraversItemsFromTopToBottom() {
        int last = 99;
        for (String s : stack) {
            assertEquals(String.valueOf(last--), s);
        }
    }
}