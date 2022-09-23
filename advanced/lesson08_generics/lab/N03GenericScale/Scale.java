package lesson08_generics.lab.N03GenericScale;

public class Scale<T extends Comparable<T>> {
    private final T left;
    private final T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        return (left.compareTo(right) < 0)
                ? right
                : (left.compareTo(right) == 0)
                    ? null
                    : left;
    }
}
