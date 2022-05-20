package datatypesandvariables.exercise;

import java.util.Scanner;

public class N05_Print_Part_Of_ASCII_Table {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startNum = Integer.parseInt(scanner.nextLine());
        int endNum = Integer.parseInt(scanner.nextLine());
        String output = "";
        for (int i = startNum; i <= endNum; i++) {
            //System.out.println(String.valueOf((char) i));
            output = output.concat(String.valueOf((char) i)).concat(" ");
        }
        System.out.println(output);
    }
}
