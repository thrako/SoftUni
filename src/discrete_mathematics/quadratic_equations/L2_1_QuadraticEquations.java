package quadratic_equations;

import java.util.Scanner;

public class L2_1_QuadraticEquations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("(a)x^2 + (b)x + (c) = 0");
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
            System.out.printf("The only solution (root) is %f%n", x);
        } else {
            double sqrtD = Math.sqrt(discriminant);

            double x1 = (-b + sqrtD) / (2 * a);
            double x2 = (-b - sqrtD) / (2 * a);
            System.out.printf("The solutions are %.0f and %.0f%n", x1, x2);
            String signX1 = (x1 < 0) ? "-" : "";
            String signX2 = (x2 < 0) ? "-" : "";
            System.out.printf("The solutions in sqrt are: %sSQRT(%.0f) and %sSQRT(%.0f)%n", signX1, x1 * x1, signX2, x2 * x2);
        }
    }
}
