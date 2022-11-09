package lesson04_methods.lab;

import java.util.Scanner;

public class N09GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        String firstVar = scanner.nextLine();
        String secondVar = scanner.nextLine();
        String result;


        switch (type.toLowerCase()) {
            case "int":
                int firstInt = Integer.parseInt(firstVar);
                int secondInt = Integer.parseInt(secondVar);
                result = getMax(firstInt, secondInt);
                break;
            case "char":
                char firstChar = firstVar.charAt(0);
                char secondChar = secondVar.charAt(0);
                result = getMax(firstChar, secondChar);
                break;
            case "string":
                result = getMax(firstVar, secondVar);
                break;
            default:
                result = "Type not supported!";
        }
        System.out.println(result);
    }

    private static String getMax(int first, int second) {
        return String.valueOf(Math.max(first, second));
    }

    private static String getMax(char first, char second) {
        return String.valueOf((char) Math.max(first, second));
    }

    private static String getMax(String first, String second) {
        if (first.compareTo(second) >= 0) return first;
        return second;
    }
}
