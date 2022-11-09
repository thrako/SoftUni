package lesson04_methods.more;

import java.util.Scanner;

public class N01DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        switch (type) {
            case "int":
                process(Integer.parseInt(scanner.nextLine()));
                break;
            case "real":
                process(Double.parseDouble(scanner.nextLine()));
                break;
            case "string":
                process(scanner.nextLine());
                break;
        }
    }

    private static void process(int num) {
        System.out.println(num * 2);
    }

    private static void process(double realNum) {
        System.out.printf("%.2f%n", realNum * 1.5);
    }

    private static void process(String str) {
        System.out.println("$" + str + "$");
    }
}
