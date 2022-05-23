package lesson01basicsyntax.lab;

public class N08_Divisible_By_3 {
    public static void main(String[] args) {
        int divisor = 3;
        for (int i = 1; i < 101; i++) {
            if (i % divisor == 0) {
                System.out.println(i);
            }
        }
    }
}
