package lesson08_generics.exercise.N07CustomList;

import java.util.ArrayList;
import java.util.Collections;

public class CustomList<T extends Comparable<T>> extends ArrayList<T>  {

    public CustomList() {
    }

    public void swap(int firstIdx, int secondIdx) {
        T temp = this.get(firstIdx);
        this.set(firstIdx, this.get(secondIdx));
        this.set(secondIdx, temp);
    }

    public int countGreaterThan(T element) {
        return (int) this.stream()
                .filter(b -> b.compareTo(element) > 0)
                .count();
    }

    public T getMin() {
        return this.stream()
                .sorted()
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public T getMax() {
        return this.stream()
                .sorted(Collections.reverseOrder())
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
