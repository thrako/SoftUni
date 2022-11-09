package practice_past_exams.fin.exam04_20200404_regular;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class N03HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Map<String, Hero> heroes = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        int numHeroes = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numHeroes; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int hitPoints = Integer.parseInt(data[1]);
            int manaPoints = Integer.parseInt(data[2]);
            heroes.putIfAbsent(name, new Hero(name, hitPoints, manaPoints));
        }

        String[] commands = scanner.nextLine().split(Pattern.quote(" - "));
        while (!"End".equals(commands[0])) {
            String action = commands[0];
            String name = commands[1];
            Hero hero = heroes.get(name);
            switch (action) {
                case "CastSpell": {
                    int manaPoints = Integer.parseInt(commands[2]);
                    String spellName = commands[3];
                    hero.castSpell(manaPoints, spellName);
                }
                break;
                case "TakeDamage": {
                    int damage = Integer.parseInt(commands[2]);
                    String attacker = commands[3];
                    hero.takeDamage(damage, attacker, heroes);
                }
                break;
                case "Recharge": {
                    int amount = Integer.parseInt(commands[2]);
                    hero.recharge(amount);
                }
                break;
                case "Heal": {
                    int amount = Integer.parseInt(commands[2]);
                    hero.heal(amount);
                }
                break;
                default:
            }
            commands = scanner.nextLine().split(Pattern.quote(" - "));
        }
        heroes.values().forEach(System.out::println);
    }

    private static class Hero {
        private static final int MAX_HIT_POINTS = 100;
        private static final int MAX_MANA_POINTS = 200;
        private final String name;
        private int hitPoints;
        private int manaPoints;

        public Hero(String name, int hitPoints, int manaPoints) {
            this.name = name;
            this.hitPoints = hitPoints;
            this.manaPoints = manaPoints;
        }

        public void castSpell(int castManaPoints, String spellName) {
            if (this.manaPoints >= castManaPoints) {
                this.manaPoints -= castManaPoints;
                System.out.printf("%s has successfully cast %s and now has %d MP!%n",
                        this.name, spellName, this.manaPoints);
            } else {
                System.out.printf("%s does not have enough MP to cast %s!%n",
                        this.name, spellName);
            }
        }

        public void takeDamage(int damage, String attacker, Map<String, Hero> heroes) {
            this.hitPoints -= damage;
            if (this.hitPoints > 0) {
                System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                        this.name, damage, attacker, this.hitPoints);
            } else {
                heroes.remove(this.name);
                System.out.printf("%s has been killed by %s!%n",
                        this.name, attacker);
            }
        }

        public void recharge(int manaPoints) {
            int rechargedManaPoints = Math.min(manaPoints, MAX_MANA_POINTS - this.manaPoints);
            this.manaPoints += rechargedManaPoints;
            System.out.printf("%s recharged for %d MP!%n",
                    this.name, rechargedManaPoints);
        }

        public void heal(int hitPoints) {
            int recoveredHitPoints = Math.min(hitPoints, MAX_HIT_POINTS - this.hitPoints);
            this.hitPoints += recoveredHitPoints;
            System.out.printf("%s healed for %d HP!%n",
                    this.name, recoveredHitPoints);
        }

        @Override
        public String toString() {
            return String.format("%s%n  HP: %d%n  MP: %d",
                    this.name, this.hitPoints, this.manaPoints);
        }
    }

}
