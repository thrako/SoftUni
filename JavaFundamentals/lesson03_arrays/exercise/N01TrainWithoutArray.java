package lesson03_arrays.exercise;

import java.util.Scanner;

public class N01TrainWithoutArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wagons = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < wagons; i++) {
            String input = scanner.nextLine();
            sb.append(input).append(" ");
            sum += Integer.parseInt(input);
        }
        System.out.println(sb);
        System.out.println(sum);
    }
}