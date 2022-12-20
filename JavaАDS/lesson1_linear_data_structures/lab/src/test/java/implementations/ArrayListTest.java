package implementations;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class ArrayListTest {

    @Test
    public void addShouldIncreaseCount() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        assertEquals(1, numbers.size());
    }

    @Test
    public void addShouldIncreaseSize() {
        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
        }

        assertEquals(100, strings.size());
    }

    @Test
    public void testAddShouldReturnTrue() {
        ArrayList<Integer> integers = new ArrayList<>();
        assertTrue(integers.add(-55));

    }

    @Test
    public void removeShouldReduceSize() {
        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
        }
        int n = 50;
        while (n-- > 0) {
            strings.remove(0);
        }

        assertEquals(50, strings.size());
    }

    @Test
    public void testIndexOfShouldReturnMinusOneForEmptyList() {
        ArrayList<String> strings = new ArrayList<>();

        assertEquals(-1, strings.indexOf("1"));
    }

    @Test
    public void testIndexOfShouldReturnCorrectIndex() {
        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
        }

        assertEquals(73, strings.indexOf("73"));
    }

    @Test
    public void testContainsReturnFalseForEmptyList() {
        ArrayList<String> strings = new ArrayList<>();

        assertFalse(strings.contains("1"));
        strings.add("1");
        assertTrue(strings.contains("1"));
    }

    @Test
    public void testContainsReturnTrue() {
        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
        }

        assertTrue(strings.contains("73"));
    }

    @Test
    public void testSizeShouldReturnZeroEmptyList() {
        ArrayList<String> strings = new ArrayList<>();
        assertEquals(0, strings.size());
        strings.add("SingleElement");
        assertEquals(1, strings.size());
    }

    @Test
    public void testSizeShouldReturnOneHundred() {
        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
        }

        assertEquals(100, strings.size());
    }

    @Test
    public void testIsEmptyReturnTrueEmptyList() {
        ArrayList<String> strings = new ArrayList<>();

        assertTrue(strings.isEmpty());
    }

    @Test
    public void testIsEmptyShouldReturnFalse() {
        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
        }
        assertTrue(new ArrayList<>().isEmpty());
        assertFalse(strings.isEmpty());
    }

    @Test
    public void testIterator() {
        ArrayList<String> strings = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
            stringBuilder.append(i);
        }

        String values = stringBuilder.toString();

        Iterator<String> iter = strings.iterator();
        assertNotNull(iter);
        int counter = 0;
        for (iter = strings.iterator();iter.hasNext();) {
            if (values.contains(iter.next())) {
                counter++;
            } else {
                counter = -1;
                break;
            }
        }

        assertEquals(strings.size(), counter);
    }

    @Test
    public void testRemoveShouldReturnCorrectElementsAndShiftTheRemaining() {
        ArrayList<String> strings = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
            stringBuilder.append(i);
        }

        String values = stringBuilder.toString();

        String removed = strings.remove(0);
        assertNotNull(removed);
        int index = 0;
        for (int i = 0; i < values.length(); i++) {
            assertEquals(values.charAt(i), removed.charAt(index++));
            if (index == removed.length() && i < values.length() - 1) {
                index = 0;
                removed = strings.remove(0);
            }
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveShouldThrowWithInvalidIndex() {
        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
        }

        strings.remove(strings.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveShouldThrowWithInvalidIndexZero() {
        ArrayList<String> strings = new ArrayList<>();

        strings.remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveShouldThrowWithInvalidIndexMinusOne() {
        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
        }

        strings.remove(-1);
    }

    @Test
    public void testGetShouldReturnTheCorrectElement() {
        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
        }
        assertEquals("99", strings.get(99));
    }

    @Test
    public void testSetShouldChangeTheElement() {
        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
        }

        strings.set(99, "666");
        assertEquals("666", strings.get(99));
    }

    @Test
    public void addAndGetMultipleElements() {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        for (Integer i = 0; i < 100; i++) {
            assertEquals(i, list.get(i));
        }
    }

    @Test
    public void testInsertShouldSetCorrectlyAndShiftRestToTheRight() {
        ArrayList<String> strings = new ArrayList<>();


        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
            if (i == 50) {
                stringBuilder.append("666");
            }
            stringBuilder.append(i);
        }

        strings.add(50, "666");

        assertEquals("666", strings.get(50));

        String values = stringBuilder.toString();

        StringBuilder sb = new StringBuilder();

        for (String number : strings) {
            sb.append(number);
        }

        assertEquals(values, sb.toString());
    }
}