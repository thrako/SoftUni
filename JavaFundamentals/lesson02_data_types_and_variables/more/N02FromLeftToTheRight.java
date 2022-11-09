package lesson02_data_types_and_variables.more;

import java.util.Scanner;

public class N02FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < lines; i++) {
            long left = scanner.nextLong();
            long right = scanner.nextLong();
            long sum = 0;
            long bigger = Math.abs(Math.max(left, right));
            while (bigger > 0) {
                sum += bigger % 10;
                bigger /= 10;
            }
            System.out.println(sum);

        }
    }
}
