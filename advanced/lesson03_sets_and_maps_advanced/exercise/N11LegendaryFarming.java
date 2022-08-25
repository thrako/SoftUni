package lesson03_sets_and_maps_advanced.exercise;

import java.util.*;

public class N11LegendaryFarming {
    public static void main(String[] args) {
        Map<String, String> legendaryItems = new HashMap<>();
        legendaryItems.put("shards", "Shadowmourne");
        legendaryItems.put("fragments", "Valanyr");
        legendaryItems.put("motes", "Dragonwrath");

        Map<String, Integer> keyMaterialsQty = new TreeMap<>();
        keyMaterialsQty.put("shards", 0);
        keyMaterialsQty.put("fragments", 0);
        keyMaterialsQty.put("motes", 0);

        Map<String, Integer> junkMaterialsQty = new TreeMap<>();

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
                switch (material) {
                    case "shards":
                    case "fragments":
                    case "motes":
                        qty = keyMaterialsQty.getOrDefault(material, 0);
                        if (qty + currQty >= 250) {
                            System.out.printf("%s obtained!%n", legendaryItems.get(material));
                            keyMaterialsQty.put(material, qty + currQty - 250);
                            break game;
                        }
                        keyMaterialsQty.put(material, qty + currQty);
                        break;
                    default:
                        qty = junkMaterialsQty.getOrDefault(material, 0);
                        junkMaterialsQty.putIfAbsent(material, 0);
                        junkMaterialsQty.put(material, qty + currQty);
                }
            }
        }
        keyMaterialsQty.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));
        junkMaterialsQty.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}
