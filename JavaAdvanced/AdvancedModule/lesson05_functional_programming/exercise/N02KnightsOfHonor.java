package lesson05_functional_programming.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class N02KnightsOfHonor {
    public static void main(String[] args) {
        Consumer<String> printKnight = string -> System.out.println("Sir " + string);
        Scanner scanner = new Scanner(System.in);
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(printKnight);
    }
}
