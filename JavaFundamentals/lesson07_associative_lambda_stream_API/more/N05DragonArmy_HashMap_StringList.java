package lesson07_associative_lambda_stream_API.more;

import java.util.*;

public class N05DragonArmy_HashMap_StringList {
    public static void main(String[] args) {
        HashMap<String, List<Dragon>> typeDragonsList = consoleFill();
        printFormatted(typeDragonsList);
    }

    private static HashMap<String, List<Dragon>> consoleFill() {
        HashMap<String, List<Dragon>> typeDragonsList = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);

        int numLines = Integer.parseInt(scanner.nextLine());
        while (numLines-- > 0) {
            int counter = -1;
            String[] line = scanner.nextLine().split("\\s+");
            String type = line[++counter];
            String name = line[++counter];
            String damage = line[++counter];
            String health = line[++counter];
            String armor = line[++counter];

            typeDragonsList.putIfAbsent(type, new ArrayList<>());
            List<Dragon> listOfType = typeDragonsList.get(type);
            listOfType.stream()
                    .filter(dragon -> dragon.getName().equals(name))
                    .findAny()
                    .ifPresentOrElse(
                            dragon -> {
                                dragon.setDamage(damage);
                                dragon.setHealth(health);
                                dragon.setArmor(armor);
                            },
                            () -> {
                                listOfType.add(new Dragon(name, damage, health, armor));
                            }
                    );
        }
        return typeDragonsList;
    }

    private static void printFormatted(HashMap<String, List<Dragon>> typeDragonsList) {

        typeDragonsList.forEach((type, dragonsList) -> {

            double avgDamage = dragonsList.stream().mapToInt(Dragon::getDamage).summaryStatistics().getAverage();
            double avgHealth = dragonsList.stream().mapToInt(Dragon::getHealth).summaryStatistics().getAverage();
            double avgArmor = dragonsList.stream().mapToInt(Dragon::getArmor).summaryStatistics().getAverage();

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type, avgDamage, avgHealth, avgArmor);
            dragonsList.stream()
                    .sorted(Comparator.comparing(Dragon::getName))
                    .forEach(System.out::println);
        });
    }

    private static class Dragon {
        private static final int DEFAULT_DAMAGE = 45;
        private static final int DEFAULT_HEALTH = 250;
        private static final int DEFAULT_ARMOR = 10;

        private final String name;
        private int damage;
        private int health;
        private int armor;

        public Dragon(String name, String damage, String health, String armor) {
            this.name = name;
            this.setDamage(damage);
            this.setHealth(health);
            this.setArmor(armor);
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
