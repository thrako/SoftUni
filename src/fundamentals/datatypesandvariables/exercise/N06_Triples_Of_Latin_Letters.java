package datatypesandvariables.exercise;

import java.util.Scanner;

public class N06_Triples_Of_Latin_Letters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 97; i < (97 + num); i++) {
            for (int j = 97; j < (97 + num); j++) {
                for (int k = 97; k < (97 + num); k++) {
                    String output = String.valueOf((char) i)
                            .concat(String.valueOf((char) j)
                            .concat(String.valueOf((char) k)));
                    System.out.println(output);
                }
            }
        }
    }
}
