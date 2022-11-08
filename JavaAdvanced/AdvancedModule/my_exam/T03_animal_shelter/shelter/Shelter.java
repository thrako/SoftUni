package my_exam.T03_animal_shelter.shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    private int capacity; //private final int capacity => failed Judge test
    private List<Animal> data; //private final List<Animal> data; => failed Judge test

    public Shelter(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (data.size() < capacity) {
            data.add(animal);
        }
    }

    public boolean remove(String name) {
        return data.remove(data.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null));
    }
    
    public Animal getAnimal(String petName, String caretakerName) {
        return data.stream()
                .filter(p -> p.getName().equals(petName) && p.getCaretaker().equals(caretakerName))
                .findFirst()
                .orElse(null);
    }
    
    public Animal getOldestAnimal() {
        return data.stream()
                .max(Comparator.comparing(Animal::getAge))
                .orElse(null);
    }
    
    public int getCount() {
        return data.size();
    }
    
    public String getStatistics() {
        StringBuilder strBld = new StringBuilder();
        strBld.append("The shelter has the following animals:").append(System.lineSeparator());
        data.forEach(p -> strBld.append(p.getName()).append(" ").append(p.getCaretaker()).append(System.lineSeparator()));
        return strBld.toString();
    }
}
