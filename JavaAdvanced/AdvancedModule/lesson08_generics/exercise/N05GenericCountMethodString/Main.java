package lesson08_generics.exercise.N05GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Box<String>> boxes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int linesCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < linesCount; i++) {
            boxes.add(new Box<>(scanner.nextLine()));
        }
        Box<String> elementBox = new Box<>(scanner.nextLine());
        System.out.println(countGreater(boxes, elementBox));
    }

    private static <T extends Comparable<T>> long countGreater(List<Box<T>> boxes, Box<T> elementBox) {
        return boxes.stream()
                .filter(b -> b.compareTo(elementBox) > 0)
                .count();
    }
}
