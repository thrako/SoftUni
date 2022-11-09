package practice_past_exams.mid.exam02_20200705_regular;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N03Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        double avgVal = numbers.stream().reduce(Integer::sum).orElse(0).doubleValue() / numbers.size();
        List<Integer> filteredSortedNumbers = numbers.stream()
                .filter(e -> e > avgVal)
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                .collect(Collectors.toList());
        int length = Math.min(filteredSortedNumbers.size(), 5);
        if (length > 0) {
            StringBuilder strBld = new StringBuilder();
            for (int i = 0; i < length - 1; i++) {
                strBld.append(filteredSortedNumbers.get(i)).append(" ");
            }
            strBld.append(filteredSortedNumbers.get(length - 1));
            System.out.println(strBld);
        } else {
            System.out.println("No");
        }
    }
}
