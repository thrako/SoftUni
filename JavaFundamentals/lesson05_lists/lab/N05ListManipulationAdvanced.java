package lesson05_lists.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N05ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = getList(scanner);
        String[] tokens = scanner.nextLine().split(" ");
        int num;

        while (!"end".equals(tokens[0])) {
            String command = tokens[0];
            switch (command) {
                case "Contains":
                    num = Integer.parseInt(tokens[1]);
                    System.out.println(contains(num, numbersList));
                    break;
                case "Print":
                    String type = tokens[1];
                    System.out.println(getAllEvenOrOdd(numbersList, type));
                    break;
                case "Get":
                    if ("sum".equals(tokens[1])) System.out.println(getSum(numbersList));
                    break;
                case "Filter":
                    String condition = tokens[1];
                    num = Integer.parseInt(tokens[2]);
                    System.out.println(getAllFiltered(numbersList, condition, num));
                    break;
            }
            tokens = scanner.nextLine().split(" ");
        }
    }

    private static List<Integer> getList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String contains(int num, List<Integer> numbersList) {
        for (Integer element : numbersList) {
            if (element == num) return "Yes";
        }
        return "No such number";
    }

    private static StringBuilder getAllEvenOrOdd(List<Integer> numbersList, String type) {
        StringBuilder strBld = new StringBuilder();
        for (int element : numbersList) {
            if ("even".equals(type) && element % 2 == 0) {
                strBld.append(element).append(" ");
            } else if ("odd".equals(type) && element % 2 != 0) {
                strBld.append(element).append(" ");
            }
        }
        if (strBld.length() > 0) strBld.deleteCharAt(strBld.length() - 1);
        return strBld;
    }

    private static long getSum(List<Integer> numbersList) {
        long sum = 0;
        for (int element : numbersList) {
            sum += element;
        }
        return sum;
    }

    private static StringBuilder getAllFiltered(List<Integer> numbersList, String condition, int num) {
        StringBuilder strBld = new StringBuilder();
        for (int element : numbersList) {
            if ("<".equals(condition) && element < num) {
                strBld.append(element).append(" ");
            } else if (">".equals(condition) && element > num) {
                strBld.append(element).append(" ");
            } else if (">=".equals(condition) && element >= num) {
                strBld.append(element).append(" ");
            } else if ("<=".equals(condition) && element <= num) {
                strBld.append(element).append(" ");
            }
        }
        if (strBld.length() > 0) strBld.deleteCharAt(strBld.length() - 1);
        return strBld;
    }
}
