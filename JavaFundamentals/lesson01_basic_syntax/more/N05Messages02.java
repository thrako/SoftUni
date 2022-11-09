package lesson01_basic_syntax.more;

import java.util.Scanner;

public class N05Messages02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLines = Integer.parseInt(scanner.nextLine());
        String msg = "";

        for (int i = 0; i < numLines; i++) {
            String symb;
            int input = Integer.parseInt(scanner.nextLine());

            if (input == 0) {
                symb = " ";
            } else {
                int length = (int) Math.log10(Math.abs(input)) + 1;
                int main = input % 10;
                int offset = (main - 2) * 3 + length;
                if (main > 7) offset += 1;
                symb = String.valueOf((char) (96 + offset));
            }

            msg = msg.concat(symb);
        }
        System.out.println(msg);
    }
}

