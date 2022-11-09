package lesson02_data_types_and_variables.more;

import java.util.Scanner;

public class N05DecryptingMessages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        int lines = Integer.parseInt(scanner.nextLine());
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < lines; i++) {
            char input = (char) (scanner.nextLine().charAt(0) + key);
            msg.append(input);
        }
        System.out.println(msg);
    }
}
