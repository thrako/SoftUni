package lesson08_generics.lab.N04ListUtilities;

import java.util.Collections;
import java.util.List;

public class ListUtils {

    public static <T> T getMin(List<T> list) {
        return list.stream()
                .sorted()
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public static <T> T getMax(List<T> list) {
        return list.stream()
                .sorted(Collections.reverseOrder())
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
