package lesson08_generics.exercise.N05GenericCountMethodString;

public class Box<T extends Comparable<T>> {
    private final T element;

    public Box(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", element.getClass().toString().substring(6), element);
    }

    public int compareTo(Box<T> otherBox) {
        return this.element.compareTo(otherBox.element);
    }
}
