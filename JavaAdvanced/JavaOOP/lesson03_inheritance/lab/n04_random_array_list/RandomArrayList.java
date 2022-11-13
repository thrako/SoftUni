package lesson03_inheritance.lab.n04_random_array_list;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomArrayList <T> extends ArrayList<T> {

    public T getRandomElement() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("list is empty");
        }
        Random random = new Random();
        final int index = random.nextInt(this.size());
        return this.get(index);
    }

}
