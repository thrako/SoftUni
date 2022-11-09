package practice_past_exams.mid.exam04_20200229_regular;

import java.util.Scanner;

public class N01GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double foodQty = Double.parseDouble(scanner.nextLine()) * 1000;
        double hayQty = Double.parseDouble(scanner.nextLine()) * 1000;
        double coverQty = Double.parseDouble(scanner.nextLine()) * 1000;
        double guineaPigWeight = Double.parseDouble(scanner.nextLine()) * 1000;
        int days = 1;
        while (days <= 30) {
            foodQty -= 300;
            if (days % 2 == 0) {
                hayQty -= foodQty * 0.05;
            }
            if (days % 3 == 0) {
                coverQty -= guineaPigWeight / 3;
            }
            if (foodQty <= 0 || hayQty <= 0 || coverQty <= 0) break;
            days++;
        }

        if (days <= 30) {
            System.out.println("Merry must go to the pet store!");
        } else {
            System.out.printf(
                    "Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.%n",
                    foodQty / 1000, hayQty / 1000, coverQty / 1000
            );
        }

    }
}
