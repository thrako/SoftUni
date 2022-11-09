package lesson07_associative_lambda_stream_API.more;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N05DragonArmy_ListObjects {
    public static void main(String[] args) {
        List<Dragon> dragonList = consoleFill();
        printFormatted(dragonList);
    }

    private static List<Dragon> consoleFill() {
        List<Dragon> dragonList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int numDragons = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numDragons; i++) {
            int counter = -1;
            String[] line = scanner.nextLine().split("\\s+");
            String type = line[++counter];
            String name = line[++counter];
            String damage = line[++counter];
            String health = line[++counter];
            String armor = line[++counter];
            dragonList.stream().filter(d -> d.getName().equals(name) && d.getType().equals(type))
                    .findAny()
                    .ifPresentOrElse(
                            existingDragon -> {
                        existingDragon.setDamage(damage);
                        existingDragon.setHealth(health);
                        existingDragon.setArmor(armor);
                    }, () -> {
                        Dragon newDragon = new Dragon(type, name, damage, health, armor);
                        dragonList.add(newDragon);
                    });
        }
        return dragonList;
    }

    private static void printFormatted(List<Dragon> dragonList) {
        List<String> types = dragonList.stream()
                .map(Dragon::getType)
                .distinct()
                .collect(Collectors.toList());

        types.forEach(type -> {
            List<Dragon> dragonsOfType = dragonList.stream()
                    .filter(d -> d.getType().equals(type))
                    .collect(Collectors.toList());

            double avgDamage = dragonsOfType.stream().mapToInt(Dragon::getDamage).summaryStatistics().getAverage();
            double avgHealth = dragonsOfType.stream().mapToInt(Dragon::getHealth).summaryStatistics().getAverage();
            double avgArmor = dragonsOfType.stream().mapToInt(Dragon::getArmor).summaryStatistics().getAverage();

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type, avgDamage, avgHealth, avgArmor);
            dragonsOfType.stream()
                    .sorted(Comparator.comparing(Dragon::getName))
                    .forEach(System.out::println);
        });
    }

    private static class Dragon {
        private static final int DEFAULT_DAMAGE = 45;
        private static final int DEFAULT_HEALTH = 250;
        private static final int DEFAULT_ARMOR = 10;

        private final String type;
        private final String name;
        private int damage;
        private int health;
        private int armor;

        public Dragon(String type, String name, String damage, String health, String armor) {
            this.type = type;
            this.name = name;
            this.setDamage(damage);
            this.setHealth(health);
            this.setArmor(armor);
        }

        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        public int getDamage() {
            return damage;
        }

        public void setDamage(String damage) {
            this.damage = (damage.equals("null")) ? DEFAULT_DAMAGE : Integer.parseInt(damage);
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(String health) {
            this.health = (health.equals("null")) ? DEFAULT_HEALTH : Integer.parseInt(health);
        }

        public int getArmor() {
            return armor;
        }

        public void setArmor(String armor) {
            this.armor = (armor.equals("null")) ? DEFAULT_ARMOR : Integer.parseInt(armor);
        }

        @Override
        public String toString() {
            return String.format(
                    "-%s -> damage: %d, health: %d, armor: %d",
                    name, damage, health, armor
            );
        }
    }
}
