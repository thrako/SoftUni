package implementations;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class ArrayDequeTest {
    ArrayDeque<String> deque;

    @Before
    public void setDeque() {
        this.deque = new ArrayDeque<>();
    }

    @Test
    public void testAddShouldAddElementAtTheEnd() {
        deque.addFirst("55");
        deque.addFirst("66");
        addZeroToMinusFiveInFront();
        addOneToTen();
        deque.addLast("333");

        String expected = "333";
        final String actual = deque.removeLast();
        assertEquals(expected, actual);
    }

    @Test
    public void testOfferShouldAddElementAtTheBeginning() {
        addOneToTen();

        String expectedFirst = "10";
        String actual = deque.peek();
        assertEquals(expectedFirst, actual);

        String expectedLast = "10";
        for (int i = 0; i < 9; i++) {
            actual = deque.poll();
            assertNotEquals(expectedLast, actual);
        }
        assertEquals(expectedLast, deque.poll());
    }

    @Test
    public void testAddFirstShouldAddElementInFrontOfAllOthers() {
        addOneToTen();
        addZeroToMinusFiveInFront();

        String expectedFirst = "13";
        deque.addFirst("13");
        assertEquals(expectedFirst, deque.removeFirst());
    }

    @Test
    public void testAddLastShouldAddElementAtTheEnd() {
        addOneToTen();
        addZeroToMinusFiveInFront();

        deque.addLast("11");
        String expected = "11";
        assertEquals(expected, deque.removeLast());
    }

    @Test
    public void testPushShouldBehaveAsAStack() {
        addOneToTen();

        deque.push("203");
        deque.push("204");
        deque.push("205");

        String expected = "205";
        assertEquals(expected, deque.peek());
        assertEquals(expected, deque.pop());
    }

    @Test
    public void testInsertShouldInsertAnElementAtTheGivenIndex() {
        addOneToTen();

        String expected = "Bla";
        deque.insert(5,expected);

        for (int i = 0; i < 11; i++) {
            if (i < 5) {
                assertEquals(String.valueOf(i + 1), deque.get(i));
            } else if (i == 5) {
                assertEquals(expected, deque.get(i));
            } else {
                assertEquals(String.valueOf(i), deque.get(i));
            }

        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertShouldThrowWithInvalidIndex() {
        addOneToTen();
        deque.insert(12, "Gotcha");
    }

    @Test
    public void testSetShouldReplaceValue() {
        deque.addFirst("0");
        addOneToTen();
        final String oldElement = deque.get(3);
        final String expected = "Bla";
        deque.set(3, expected);
        final String newElement = deque.get(3);
        assertNotEquals(oldElement, newElement);
        assertEquals(expected, newElement);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetShouldThrowWithInvalidIndex() {
        addOneToTen();
        deque.set(12, "Gotcha");
    }

    @Test
    public void testPeekShouldReturnCorrectValueForBothStackAndQueue() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(3);
        queue.offer(2);
        queue.offer(1);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        final int expected = 3;

        final int queueActual = queue.peek();
        assertEquals(expected, queueActual);

        final int stackActual = stack.peek();
        assertEquals(expected, stackActual);
    }

    @Test
    public void testPeekShouldReturnNullOnEmptyDeque() {
        ArrayDeque<String> peekDeque = new ArrayDeque<>();
        assertNull(peekDeque.peek());

        peekDeque.push("Bla");
        peekDeque.push("Bla");
        peekDeque.push("Bla");
        assertNotNull(peekDeque.peek());

        peekDeque.pop();
        peekDeque.pop();
        peekDeque.pop();
        assertNull(peekDeque.peek());
    }

    @Test
    public void testPollShouldReturnTheElementAtTheFront() {
        addOneToTen();
        assertEquals("1", deque.poll());
        assertEquals("2", deque.poll());
        assertEquals("3", deque.poll());
    }

    @Test
    public void testPollShouldReturnNullOnEmptyDeque() {
        ArrayDeque<String> pollDeque = new ArrayDeque<>();
        for (int i = 0; i < 50; i++) {
            assertNull(pollDeque.poll());
        }

        pollDeque.offer("Bla");
        pollDeque.offer("Bla");
        pollDeque.offer("Bla");
        assertNotNull(pollDeque.poll());
        assertNotNull(pollDeque.poll());
        assertNotNull(pollDeque.poll());

        for (int i = 0; i < 50; i++) {
            assertNull(pollDeque.poll());
        }
    }

    @Test
    public void testPopShouldReturnTheElementAtTheEnd() {
        addOneToTen();
        assertEquals("10", deque.pop());
        assertEquals("9", deque.pop());
        assertEquals("8", deque.pop());
    }

    @Test
    public void testPopShouldReturnNullOnEmptyDeque() {
        ArrayDeque<String> pollDeque = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            assertNull(pollDeque.pop());
        }

        pollDeque.offer("Bla");
        pollDeque.offer("Bla");
        pollDeque.offer("Bla");
        assertNotNull(pollDeque.pop());
        assertNotNull(pollDeque.pop());
        assertNotNull(pollDeque.pop());

        for (int i = 0; i < 10; i++) {
            assertNull(pollDeque.pop());
        }
    }

    @Test
    public void testGetByIndexReturnsCorrectly() {
        addOneToTen();
        assertEquals("7", deque.get(6));
        assertEquals("3", deque.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetByIndexShouldThrowWithInvalidIndex() {
        addOneToTen();
        deque.get(55);
    }

    @Test
    public void testGetByValueReturnsFirstOccurrence() {
        addOneToTen();
        deque.insert(7,"3");
        assertEquals("3", deque.get("3"));
        assertEquals("1", deque.get("1"));
        assertEquals("10", deque.get("10"));
    }

    @Test
    public void testGetByValueReturnsNullWhenValueIsNotPresent() {
        addOneToTen();
        assertNull(deque.get("73"));
    }

    @Test
    public void testRemoveByIndexReturnsTheCorrectElement() {
        addOneToTen();
        assertEquals("7", deque.remove(6));
        assertEquals("8", deque.remove(6));
        assertEquals("10", deque.remove(7));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveByIndexThrowsWhenIndexIsNotValid() {
        addOneToTen();
        deque.remove(10);
    }

    @Test
    public void testRemoveByValueReturnsTheFirstOccurrence() {
        addOneToTen(); // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        deque.insert(7, "3"); // 1, 2, 3, 4, 5, 6, 7, (in ->) 3, 8, 9, 10
        deque.remove("3"); // 1, 2, (3 <- out), 4, 5, 6, 7, 3, 8, 9, 10

        List<String> actualList = List.of("1", "2", "4", "5", "6", "7", "3", "8", "9", "10");

        for (int i = 0; i < 10; i++) {
            assertEquals(actualList.get(i), deque.get(i));
        }
    }

    @Test
    public void testRemoveByValueReturnsNullWhenValueIsMissing() {
        addOneToTen();

        assertNull(deque.remove("73"));
        assertNull(deque.remove("-1"));
        assertNull(deque.remove("11"));
        assertNull(deque.remove("-1024"));
        assertNull(deque.remove("Bla"));

        deque.insert(7, "3"); // 1, 2, 3, 4, 5, 6, 7, (in ->) 3, 8, 9, 10

        assertNotNull(deque.remove("3"));
        assertNotNull(deque.remove("3"));
        assertNull(deque.remove("3"));
    }

    @Test
    public void testRemoveFirstShouldReturnTheElementAtTheFront() {
        addOneToTen();
        assertEquals("1", deque.removeFirst());
        assertEquals("2", deque.removeFirst());
        assertEquals("3", deque.removeFirst());
    }

    @Test
    public void testRemoveFirstShouldReturnNullOnEmptyDeque() {
        ArrayDeque<String> removeFirstDeque = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            assertNull(removeFirstDeque.removeFirst());
        }

        removeFirstDeque.addFirst("Bla");
        removeFirstDeque.addFirst("Bla");
        removeFirstDeque.addFirst("Bla");

        assertNotNull(removeFirstDeque.removeFirst());
        assertNotNull(removeFirstDeque.removeFirst());
        assertNotNull(removeFirstDeque.removeFirst());

        for (int i = 0; i < 10; i++) {
            assertNull(removeFirstDeque.removeFirst());
        }
    }

    @Test
    public void testRemoveLastReturnsTheLastElement() {
        addOneToTen();

        for (int i = 10; i > 0; i--) {
            assertEquals(String.valueOf(i), deque.removeLast());
        }
    }

    @Test
    public void testRemoveLastShouldReturnNullOnEmptyDeque() {
        ArrayDeque<String> removeLastDeque = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            assertNull(removeLastDeque.removeLast());
        }

        removeLastDeque.addLast("Bla");
        removeLastDeque.addLast("Bla");
        removeLastDeque.addLast("Bla");

        assertNotNull(removeLastDeque.removeLast());
        assertNotNull(removeLastDeque.removeLast());
        assertNotNull(removeLastDeque.removeLast());

        for (int i = 0; i < 10; i++) {
            assertNull(removeLastDeque.removeLast());
        }
    }

    @Test
    public void testSizeShouldReturnCorrectSize() {
        assertEquals(deque.size(), 0);

        deque.removeLast();
        assertEquals(deque.size(), 0);

        deque.removeFirst();
        assertEquals(deque.size(), 0);

        deque.remove("Bla");
        assertEquals(deque.size(), 0);

        addOneToTen();
        assertEquals(10, deque.size());

        for (int i = 1; i < 6; i++) {
            deque.add("Bla");
            assertEquals(10 + i, deque.size());
        }

        for (int i = 1; i < 11; i++) {
            deque.removeLast();
            assertEquals(15 - i, deque.size());
        }

    }

    @Test
    public void testCapacityShouldReturnCurrentCapacity() {
        assertEquals(7, deque.capacity());

        addOneToTen(); //size = 10
        assertEquals(14, deque.capacity());

        addOneToTen(); //size = 20
        assertEquals(28, deque.capacity());

        for (int i = 0; i < 12; i++) {
            deque.removeLast();
        }
        //size = 8
        assertEquals(14, deque.capacity());

        for (int i = 0; i < 5; i++) {
            deque.remove(0);
        }
        //size = 3
        assertEquals(7, deque.capacity());
    }

    @Test
    public void testTrimToSizeShouldReturnEqualSizeAndCapacity() {
        deque.trimToSize();
        assertEquals(0, deque.size());
        assertEquals(0, deque.capacity());

        addOneToTen();
        deque.trimToSize();
        assertEquals(10, deque.size());
        assertEquals(10, deque.capacity());
    }

    @Test
    public void testIterator() {
        addOneToTen();
        addZeroToMinusFiveInFront();

        final Iterator<String> iterator = deque.iterator();
        int counter = -5;

        while (iterator.hasNext()) {
            final String actual = iterator.next();
            final String expected = String.valueOf(counter++);
            assertEquals(expected, actual);
        }

        assertEquals(11, counter);
    }


    private void addOneToTen() {
        deque.add("1");
        deque.add("2");
        deque.add("3");
        deque.add("4");
        deque.add("5");
        deque.add("6");
        deque.add("7");
        deque.add("8");
        deque.add("9");
        deque.add("10");
    }

    private void addZeroToMinusFiveInFront() {
        deque.addFirst("0");
        deque.addFirst("-1");
        deque.addFirst("-2");
        deque.addFirst("-3");
        deque.addFirst("-4");
        deque.addFirst("-5");
    }

}
