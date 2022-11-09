package lesson01_basic_syntax.lab;

public class N08DivisibleByThree {
    public static void main(String[] args) {
        int divisor = 3;
        for (int i = 1; i < 101; i++) {
            if (i % divisor == 0) {
                System.out.println(i);
            }
        }
    }
}
