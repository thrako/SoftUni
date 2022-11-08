package lesson08_generics.exercise.N03GenericSwapMethodStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Box<String>> boxes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            boxes.add(new Box<>(scanner.nextLine()));
        }
        int[] swapIndices = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        swap(boxes, swapIndices[0], swapIndices[1]);
        boxes.forEach(System.out::println);
    }

    private static <T> void swap(List<Box<T>> boxes, int firstIdx, int secondIdx) {
        Box<T> temp = boxes.get(firstIdx);
        boxes.set(firstIdx, boxes.get(secondIdx));
        boxes.set(secondIdx, temp);
    }
}
