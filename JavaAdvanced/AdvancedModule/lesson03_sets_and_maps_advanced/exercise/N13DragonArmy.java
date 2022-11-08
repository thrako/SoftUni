package lesson03_sets_and_maps_advanced.exercise;

import java.util.*;

public class N13DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Map<String, Integer>>> army = new LinkedHashMap<>();
        int numLines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numLines; i++) {
            int counter = -1;
            String[] line = scanner.nextLine().split("\\s+");
            String type = line[++counter];
            String name = line[++counter];
            String damageStr = line[++counter];
            int damage = (damageStr.equals("null")) ? 45 : Integer.parseInt(damageStr);
            String healthStr = line[++counter];
            int health = (healthStr.equals("null")) ? 250 : Integer.parseInt(healthStr);
            String armorStr = line[++counter];
            int armor = (armorStr.equals("null")) ? 10 : Integer.parseInt(armorStr);

            army.putIfAbsent(type, new TreeMap<>());
            var currDragon = army.get(type);
            currDragon.putIfAbsent(name, new HashMap<>());
            var currStats = currDragon.get(name);
            currStats.put("damage", damage);
            currStats.put("health", health);
            currStats.put("armor", armor);
        }

        for (var type : army.entrySet()) {
            double totalDamage = 0;
            double totalHealth = 0;
            double totalArmor = 0;
            int count = 0;
            for (Map.Entry<String, Map<String, Integer>> dragon : type.getValue().entrySet()) {
                count++;
                totalDamage += dragon.getValue().get("damage");
                totalHealth += dragon.getValue().get("health");
                totalArmor += dragon.getValue().get("armor");
            }
            System.out.printf(
                    "%s::(%.2f/%.2f/%.2f)%n",
                    type.getKey(), totalDamage/count, totalHealth/count, totalArmor/count);

            var dragon = type.getValue().entrySet();
            for (var dragonStats : dragon) {
                String name = dragonStats.getKey();
                Integer damage = dragonStats.getValue().get("damage");
                Integer health = dragonStats.getValue().get("health");
                Integer armor = dragonStats.getValue().get("armor");
                System.out.printf(
                        "-%s -> damage: %d, health: %d, armor: %d%n",
                        name, damage, health, armor
                );
            }
        }
    }
}
