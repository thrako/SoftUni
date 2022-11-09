package lesson05_lists.lab;

import java.util.*;

public class N06ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int listSize = Integer.parseInt(scanner.nextLine());
        List<String> products = new ArrayList<>(listSize);
        for (int i = 0; i < listSize; i++) {
            products.add(scanner.nextLine());
        }
        Collections.sort(products);
        for (int i = 0; i < listSize; i++) {
            System.out.printf("%d.%s%n", i + 1, products.get(i));
        }
    }
}
