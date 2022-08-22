package lesson03_sets_and_maps_advanced.lab;

import java.util.*;

public class N06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Double>> shopProductPriceMap = new HashMap<>();
        String input = scanner.nextLine();
        while (!"Revision".equals(input)) {
            String[] inputData = input.split(",\\s+");
            String shop = inputData[0];
            String product = inputData[1];
            double price = Double.parseDouble(inputData[2]);
            shopProductPriceMap.putIfAbsent(shop, new LinkedHashMap<>());
            shopProductPriceMap.get(shop).put(product, price);
            input = scanner.nextLine();
        }

        shopProductPriceMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    System.out.printf("%s->%n", entry.getKey());
                    entry.getValue()
                            .forEach((product, price) -> System.out.printf(
                                    "Product: %s, Price: %.1f%n",
                                    product, price)
                            );
                });
    }
}
