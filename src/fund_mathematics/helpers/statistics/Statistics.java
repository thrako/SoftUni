package helpers.statistics;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Statistics {
    public static void main(String[] args) {
        List<Integer> statisticalRow = new java.util.ArrayList<>(List.of(

        4, 5, 4, 5, 5, 6, 5, 5, 3, 4, 4, 4, 4, 5, 8, 4

        ));
        Scanner scanner = new Scanner(System.in);
        statisticalRow.sort(Integer::compareTo);
        System.out.println(statisticalRow);
        int moda = Integer.MIN_VALUE;

        int counter = 0, maxCounter = 0;
        for (int i = 0, statisticalRowSize = statisticalRow.size(); i < statisticalRowSize; i++) {
            Integer element = statisticalRow.get(i);
            Integer prevElement = (i > 0) ? statisticalRow.get(i - 1) : Integer.MIN_VALUE;
            if (Objects.equals(element, prevElement)) {
                counter++;
            } else {
                counter = 1;
            }
            if (counter > maxCounter) {
                maxCounter = counter;
                moda = statisticalRow.get(i);
            }
        }

        System.out.printf("Moda: %d%n", moda);

        int size = statisticalRow.size();
        double mediana = (size != 0 && size % 2 == 0)
                ? (statisticalRow.get(size/2) + statisticalRow.get(size/2 - 1)) / (double) 2
                : statisticalRow.get(size/2);
        System.out.printf("Mediana: %.2f%n", mediana);

        double avgValue = (double) statisticalRow.stream().reduce(Integer::sum).get() / (double) statisticalRow.size();
        System.out.printf("Average value: %f%n", avgValue);
    }
}
