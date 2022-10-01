package lesson08_generics.exercise.N10Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data;

        data = scanner.nextLine().split("\\s+");
        Threeuple<String, String, String> nameAddressCity = new Threeuple<>(
                data[0].concat(" ").concat(data[1]),
                data[2],
                data[3]
        );
        System.out.println(nameAddressCity);

        data = scanner.nextLine().split("\\s+");
        Threeuple<String, Integer, Boolean> nameLitersDrunk = new Threeuple<>(
                data[0],
                Integer.parseInt(data[1]),
                data[2].equals("drunk")
        );
        System.out.println(nameLitersDrunk);

        data = scanner.nextLine().split("\\s+");
        Threeuple<String, Double, String> nameBalanceBank = new Threeuple<>(
                data[0],
                Double.parseDouble(data[1]),
                data[2]
        );
        System.out.println(nameBalanceBank);
    }

}
