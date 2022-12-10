package toyStore;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ToyStoryTest {
    
    private ToyStore toyStore;
    private Toy toy1;
    private Toy toy2;
    private Toy toy3;
    
    @Before
    public void setUp() {
        this.toyStore = new ToyStore();
        this.toy1 = new Toy("Mattel", "INV243541");
        this.toy2 = new Toy("PlayGro", "INV658678121");
        this.toy3 = new Toy("HasBro", "INV46518");
    }
    
    @Test
    public void testConstructor() {
        assertTrue(toyStore instanceof ToyStore);
    }
    
    @Test(expected = UnsupportedOperationException.class)
    public void testGetToyShelfReturnsUnmodifiableMap() {
        toyStore.getToyShelf().put(toy1.getToyId(), toy1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAddToyThrowsIfShelfDoesNotExists() throws OperationNotSupportedException {
        toyStore.addToy("Alpha", toy1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAddToyThrowsIfShelfIsTaken() throws OperationNotSupportedException {
        toyStore.addToy("A", toy1);
        toyStore.addToy("A", toy2);
    }
    
    @Test(expected = OperationNotSupportedException.class)
    public void testAddToyThrowsIfSameToyIsInStore() throws OperationNotSupportedException {
        toyStore.addToy("A", toy3);
        toyStore.addToy("C", toy3);
    }
    
    @Test
    public void testAddToyAddsTheToy() throws OperationNotSupportedException {
        toyStore.addToy("A", toy3);
        assertEquals(toy3, toyStore.getToyShelf().get("A"));
        toyStore.addToy("B", toy1);
        assertEquals(toy1, toyStore.getToyShelf().get("B"));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyThrowsIfShelfDoesNotExist() {
        toyStore.removeToy("Beta", toy2);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyThrowsIfNotSameToyIsOnShelf() {
        toyStore.removeToy("A", toy3);
    }
    
    @Test
    public void testRemoveToyRemovesTheToy() throws OperationNotSupportedException {
        toyStore.addToy("B", toy2);
        String removalMessage = toyStore.removeToy("B", toy2);
        assertEquals(null, toyStore.getToyShelf().get("B"));
    
        String expectedMessage = String.format("Remove toy:%s successfully!", toy2.getToyId());
        assertEquals(expectedMessage, removalMessage);
        
    }
    
    @Test
    public void testToyGetManufacturer() {
        assertEquals("Mattel", toy1.getManufacturer());
    }
}