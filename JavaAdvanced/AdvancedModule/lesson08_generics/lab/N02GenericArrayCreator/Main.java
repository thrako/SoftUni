package lesson08_generics.lab.N02GenericArrayCreator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] strings = ArrayCreator.create(10, "none");
        Integer[] integers = ArrayCreator.create(Integer.class, 10, 0);
        System.out.println(Arrays.deepToString(strings));
        System.out.println(Arrays.deepToString(integers));
    }
}
