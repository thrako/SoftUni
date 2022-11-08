package lesson08_generics.lab.N02GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {


    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> T[] create(Class clazz, int length, T item) {
        T[] arr = (T[])Array.newInstance(clazz, length);
        Arrays.fill(arr, item);
        return arr;
    }

    public static <T> T[] create (int length, T item) {
        return create(item.getClass(), length, item);
    }

}
