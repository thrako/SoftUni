package helpers;

import java.util.Scanner;

public class L2_2_BiQuadraticEquations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("(a)x^4 + (b)x^2 + (c) = 0");
        System.out.print("a = ");
        int a = Integer.parseInt(scanner.nextLine());

        System.out.print("b = ");
        int b = Integer.parseInt(scanner.nextLine());

        System.out.print("c = ");
        int c = Integer.parseInt(scanner.nextLine());

        solve(a, b, c);
    }

    private static void solve(int a, int b, int c) {
        int discriminant = (b * b) - (4 * a * c);
        System.out.printf("Discriminant = %d%n", discriminant);

        if (discriminant < 0) {
            System.out.println("No solutions exist");
        } else if (discriminant == 0) {
            double x = (-b * 1.0) / (2 * a);
            double y = Math.sqrt(x);
            System.out.printf("The solution is SQRT(%.0f) = [+/-]%f%n", x, y);

        } else {
            double sqrtD = Math.sqrt(discriminant);

            double x1 = (-b + sqrtD) / (2 * a);
            double x2 = (-b - sqrtD) / (2 * a);

            System.out.printf("The solutions are: SQRT(%.0f) = [+/-]%.2f  && SQRT(%.0f) = [+/-]%.2f%n", x1, Math.sqrt(x1), x2, Math.sqrt(x2));

        }
    }
}
