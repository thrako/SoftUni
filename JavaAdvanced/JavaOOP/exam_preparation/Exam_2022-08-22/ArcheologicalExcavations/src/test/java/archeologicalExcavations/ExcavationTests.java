package archeologicalExcavations;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExcavationTests {
    Excavation tenCapExcavation;
    Excavation zeroCapExcavation;
    Archaeologist archaeologist1;
    Archaeologist archaeologist2;

    @Before
    public void setUp() {
        this.tenCapExcavation = new Excavation("the Pyramids", 10);
        this.zeroCapExcavation = new Excavation("Zero", 0);
        this.archaeologist1 = new Archaeologist("Test1", 11.57);
        this.archaeologist2 = new Archaeologist("Test2", 12.34);
    }

    @Test
    public void testConstructor() {
        final var excavationName = "New";
        final var excavationCapacity = 5;
        Excavation newExcavation = new Excavation(excavationName, excavationCapacity);

        assertEquals(excavationCapacity, newExcavation.getCapacity());
        assertEquals(0, newExcavation.getCount());
        assertEquals(excavationName, newExcavation.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldThrowWithNegativeNumber() {
        //noinspection unused
        Excavation newExcavation = new Excavation("NegativeCap", -1);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowWithEmptyName() {
        //noinspection unused
        Excavation newExcavation = new Excavation("   ", 5);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowWithNullName() {
        //noinspection unused
        Excavation newExcavation = new Excavation(null, 5);
    }

    @Test
    public void testAddArchaeologistShouldIncreaseCount() {
        tenCapExcavation.addArchaeologist(archaeologist1);
        tenCapExcavation.addArchaeologist(archaeologist2);

        assertEquals(2, tenCapExcavation.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowIfCapacityIsReached() {
        zeroCapExcavation.addArchaeologist(archaeologist1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowIfArcheologistExists() {
        tenCapExcavation.addArchaeologist(archaeologist1);
        tenCapExcavation.addArchaeologist(archaeologist1);
    }

    @Test
    public void testRemoveArchaeologistShouldDecreaseCount() {
        tenCapExcavation.addArchaeologist(archaeologist1);
        tenCapExcavation.addArchaeologist(archaeologist2);
        tenCapExcavation.removeArchaeologist(archaeologist1.getName());

        assertEquals(1, tenCapExcavation.getCount());
    }



}
