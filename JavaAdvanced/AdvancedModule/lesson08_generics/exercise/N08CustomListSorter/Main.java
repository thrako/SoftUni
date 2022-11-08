package lesson08_generics.exercise.N08CustomListSorter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomList<String> customList = new CustomList<>();
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        String command = input[0];
        while (!"END".equals(command)) {
            switch (command) {
                case "Add": {
                    String element = input[1];
                    customList.add(element);
                    break;
                }
                case "Remove": {
                    int index = Integer.parseInt(input[1]);
                    customList.remove(index);
                    break;
                }
                case "Contains": {
                    String element = input[1];
                    System.out.println(customList.contains(element));
                    break;
                }
                case "Swap": {
                    int firstIdx = Integer.parseInt(input[1]);
                    int secondIdx = Integer.parseInt(input[2]);
                    customList.swap(firstIdx, secondIdx);
                    break;
                }
                case "Greater": {
                    String element = input[1];
                    System.out.println(customList.countGreaterThan(element));
                    break;
                }
                case "Max": {
                    System.out.println(customList.getMax());
                    break;
                }
                case "Min": {
                    System.out.println(customList.getMin());
                    break;
                }
                case "Sort": {
                    Sorter.sort(customList);
                    break;
                }
                case "Print": {
                    customList.forEach(System.out::println);
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + command);
            }
            input = scanner.nextLine().split("\\s+");
            command = input[0];
        }
    }
}
