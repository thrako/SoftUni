package lesson08_generics.exercise.N02GenericBoxOfIntegers;

public class Box<T> {
    private final T element;

    public Box(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", element.getClass().toString().substring(6), element);
    }
}
