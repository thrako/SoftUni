package lesson08_generics.lab.N04ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 7, 2, 3, -5);
        System.out.println(ListUtils.getMin(integers));
        System.out.println(ListUtils.getMax(integers));

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "abc", "a", "xyz", "bla", "klmn");
        System.out.println(ListUtils.getMin(strings));
        System.out.println(ListUtils.getMax(strings));
    }
}
