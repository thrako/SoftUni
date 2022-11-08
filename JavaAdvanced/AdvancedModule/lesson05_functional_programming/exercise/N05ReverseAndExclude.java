package lesson05_functional_programming.exercise;

import java.util.*;
import java.util.stream.Collectors;

public class N05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int divisor = Integer.parseInt(scanner.nextLine());

        List<String> numbers = Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .filter(digit -> digit % divisor != 0)
                .map(String::valueOf)
                .collect(Collectors.toList());
        Collections.reverse(numbers);
        System.out.println(String.join(" ", numbers));
    }
}
