package lesson07_associative_lambda_stream_API.exercise;

import java.util.*;

public class N03LegendaryFarming {
    public static void main(String[] args) {
        Map<String, String> legendaryItems = new HashMap<>();
        legendaryItems.put("shards", "Shadowmourne");
        legendaryItems.put("fragments", "Valanyr");
        legendaryItems.put("motes", "Dragonwrath");

        Map<String, Integer> materialsQty = new LinkedHashMap<>();
        materialsQty.put("shards", 0);
        materialsQty.put("fragments", 0);
        materialsQty.put("motes", 0);

        Scanner scanner = new Scanner(System.in);
        String material;
        String[] inputs;
        Integer qty, currQty;
        game:
        while (true) {
            inputs = scanner.nextLine().split("\\s+");
            for (int i = 0; i < inputs.length; i = i + 2) {
                currQty = Integer.parseInt(inputs[i]);
                material = inputs[i + 1].toLowerCase();
                qty = materialsQty.getOrDefault(material, 0);
                switch (material) {
                    case "shards":
                    case "fragments":
                    case "motes":
                        if (qty + currQty >= 250) {
                            System.out.printf("%s obtained!%n", legendaryItems.get(material));
                            materialsQty.put(material, qty + currQty - 250);
                            break game;
                        }
                    default:
                        materialsQty.putIfAbsent(material, 0);
                }
                materialsQty.put(material, qty + currQty);
            }
        }
        for (Map.Entry<String, Integer> entry : materialsQty.entrySet()) {
            System.out.printf("%s: %s%n", entry.getKey(), entry.getValue());
        }
    }
}
