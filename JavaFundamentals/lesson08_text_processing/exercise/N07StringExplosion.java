package lesson08_text_processing.exercise;

import java.util.Scanner;

public class N07StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int length = str.length();
        StringBuilder strBld = new StringBuilder();
        int offset = 0;

        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == '>') {
                strBld.append(str.charAt(i));
                offset += Integer.parseInt(String.valueOf(str.charAt(i+1)));
            } else if (offset == 0) {
                strBld.append(str.charAt(i));
            } else offset--;
        }

        System.out.println(strBld);
    }
}
