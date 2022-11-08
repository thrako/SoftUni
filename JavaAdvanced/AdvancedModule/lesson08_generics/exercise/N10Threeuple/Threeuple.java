package lesson08_generics.exercise.N10Threeuple;

public class Threeuple<T1, T2, T3> extends Tuple<T1, T2> {
    T3 item3;

    public Threeuple() {}

    public Threeuple(T1 item1, T2 item2, T3 item3) {
        super(item1, item2);
        this.item3 = item3;
    }

    public T3 getItem3() {
        return item3;
    }

    public void setItem3(T3 item3) {
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", item1, item2, item3);
    }
}
