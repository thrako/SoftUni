package implementations;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReversedListTest {

    ReversedList<String> reversedList;

    @Before
    public void setUp() {
        reversedList = new ReversedList<>();
    }

    @Test
    public void testAddShouldAddAnElement() {
        reversedList.add("Bla");
        assertEquals(1, reversedList.size());
    }

    @Test
    public void testSizeReturnsCorrectly() {
        assertEquals(0, reversedList.size());

        reversedList.add("Bla");
        reversedList.add("Bla");
        reversedList.add("Bla");

        assertEquals(3, reversedList.size());

        reversedList.removeAt(0);
        reversedList.removeAt(0);

        assertEquals(1, reversedList.size());
    }

    @Test
    public void testCapacityShouldDoubleWhenFull() {
        assertEquals(2, reversedList.capacity());
        reversedList.add("Bla1");
        reversedList.add("Bla2");
        assertEquals(2, reversedList.capacity());
        reversedList.add("Bla3");
        assertEquals(4, reversedList.capacity());
        reversedList.add("Bla4");
        reversedList.add("Bla5");
        assertEquals(8, reversedList.capacity());
        reversedList.add("Bla6");
        reversedList.add("Bla7");
        reversedList.add("Bla8");
        reversedList.add("Bla9");
        assertEquals(16, reversedList.capacity());
    }

    @Test
    public void getByIndexShouldReturnCorrectValue() {

        final String expected_1 = "Alpha";
        final String expected_2 = "Bravo";
        final String expected_3 = "Charlie";

        reversedList.add(expected_1);
        reversedList.add(expected_2);
        reversedList.add(expected_3);

        assertEquals(expected_3, reversedList.get(0));
        assertEquals(expected_2, reversedList.get(1));
        assertEquals(expected_1, reversedList.get(2));
    }

    @Test
    public void removeAtShouldRemoveCorrectValue() {

        //add ten elements
        for (int i = 0; i < 10; i++) {
            reversedList.add(String.valueOf(i));
        }

        //remove five at the end
        reversedList.removeAt(3);
        reversedList.removeAt(0);
        reversedList.removeAt(1);
        reversedList.removeAt(0);
        reversedList.removeAt(0);

        //assert first five are still present
        int counter = 4;
        for (int i = 0; i < 5; i++) {
            String expected = String.valueOf(counter--);
            assertEquals(expected, reversedList.get(i));
        }

        //assert size is correct
        assertEquals(5, reversedList.size());
    }

    @Test
    public void testIterator() {
        //add ten elements
        for (int i = 0; i < 10; i++) {
            reversedList.add(String.valueOf(i));
        }

        int counter = 9;

        for (String actual : reversedList) {
            assertEquals(String.valueOf(counter--), actual);
        }
    }

    @Test
    public void removeAtShouldRemoveCorrectElement() {
        ReversedList<Integer> list = new ReversedList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.removeAt(0);
        assertEquals(1, (int)list.get(0));
    }

}
