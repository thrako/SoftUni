package lesson05_lists.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N07AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("\\|");
        List<String> orderedArrays = new ArrayList<>(line.length);
        for (int i = line.length - 1; i > -1; i--) {
            String subStr = line[i];
            subStr = subStr.trim();
            String[] subStrArr = subStr.split("\\s+");
            for (String e : subStrArr) {
                if (!e.equals("")) orderedArrays.add(e);
            }
        }
        printDelimited(orderedArrays, " ");
    }

    private static void printDelimited(List<String> strings, String delimiter) {
        StringBuilder strBld = new StringBuilder();
        for (String string : strings) strBld.append(string).append(delimiter);
        strBld.delete(strBld.length() - 1, strBld.length());
        System.out.println(strBld);
    }
}
