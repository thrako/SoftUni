package lesson02_data_types_and_variables.more;

import java.util.Scanner;

public class N01DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String dataType = "string";

            if (scanner.hasNextFloat()) dataType = "floating point";
            if (scanner.hasNextInt()) dataType = "integer";
            if (scanner.hasNextBoolean()) dataType = "boolean";

            String input = scanner.nextLine();
            if (input.length() == 1 && !dataType.equals("integer")) dataType = "character";

            if (input.equals("END")) {
                break;
            } else {
                System.out.printf("%s is %s type%n", input, dataType);
            }

        }
    }
}
