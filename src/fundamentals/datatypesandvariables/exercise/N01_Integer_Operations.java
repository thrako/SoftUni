package datatypesandvariables.exercise;

import java.util.Scanner;

public class N01_Integer_Operations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());
        int fourth = Integer.parseInt(scanner.nextLine());
        int sum = (first + second) / third * fourth;
        System.out.println(sum);
    }
}
