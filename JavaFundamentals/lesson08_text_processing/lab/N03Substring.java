package lesson08_text_processing.lab;

import java.util.Scanner;

public class N03Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String subStr = scanner.nextLine();
        String str = scanner.nextLine();
        while(str.contains(subStr)) {
            str = str.replace(subStr, "");
        }
        System.out.println(str);
    }
}
