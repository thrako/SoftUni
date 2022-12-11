package petStore;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PetStoreTests {
    private PetStore petStore;
    private Animal animal1;
    private Animal animal2;
    private Animal animal3;
    
    @Before
    public void setUp() {
        petStore = new PetStore();
        animal1 = new Animal("Dog", 20, 50.00);
        animal2 = new Animal("Cat", 10, 40.00);
        animal3 = new Animal("Mouse", 1, 5.00);
    }
    
    @Test
    public void testConstructor() {
        assertEquals(0, petStore.getCount());
    }
    
    @Test(expected = UnsupportedOperationException.class)
    public void testGetAnimalsReturnsUnmodifiableCollection() {
        List<Animal> animals = petStore.getAnimals();
        animals.add(animal1);
    }
    
    @Test
    public void testFindAllAnimalsWithMaxKilogramsReturnsCorrectly() {
        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);
        
        List<Animal> filteredAnimals = petStore.findAllAnimalsWithMaxKilograms(7);
        assertEquals(2, filteredAnimals.size());
        assertEquals(animal1, filteredAnimals.get(0));
        assertEquals(animal2, filteredAnimals.get(1));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalShouldThrowWithNullArgument() {
        petStore.addAnimal(null);
    }
    
    @Test
    public void testGetTheMostExpensiveAnimalShouldReturnCorrectly() {
        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);
        assertEquals(animal1, petStore.getTheMostExpensiveAnimal());
    }
    
    @Test
    public void testFindAllAnimalBySpecieShouldReturnCorrectly() {
        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);
        String specie = animal3.getSpecie();
        Animal animal4 = new Animal(specie, 1, 6);
        petStore.addAnimal(animal4);
        assertEquals(animal3, petStore.findAllAnimalBySpecie(specie).get(0));
        assertEquals(animal4, petStore.findAllAnimalBySpecie(specie).get(1));
    }

}

