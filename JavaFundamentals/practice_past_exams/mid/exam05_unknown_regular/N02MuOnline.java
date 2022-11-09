package practice_past_exams.mid.exam05_unknown_regular;

import java.util.Scanner;

public class N02MuOnline {
    public static void main(String[] args) {
        int health = 100;
        int bitcoins = 0;
        Scanner scanner = new Scanner(System.in);
        String[] rooms = scanner.nextLine().split("\\|");
        String[] room;
        String monster;
        int attack, hp, healedHP, chestContains;
        adventure:
        for (int i = 0, length = rooms.length; i < length; i++) {
            room = rooms[i].split("\\s+");
            switch (room[0]) {
                case "potion":
                    hp = Integer.parseInt(room[1]);
                    healedHP = Math.min(hp, 100 - health);
                    health += healedHP;
                    System.out.printf(
                            "You healed for %d hp.%n" +
                            "Current health: %d hp.%n",
                            healedHP, health
                    );
                    break;
                case "chest":
                    chestContains = Integer.parseInt(room[1]);
                    System.out.printf(
                            "You found %d bitcoins.%n",
                            chestContains
                    );
                    bitcoins += chestContains;
                    break;
                default:
                    monster = room[0];
                    attack = Integer.parseInt(room[1]);
                    health -= attack;
                    if (health > 0) {
                        System.out.printf(
                                "You slayed %s.%n",
                                monster
                        );
                    } else {
                        System.out.printf(
                                "You died! Killed by %s.%n" +
                                "Best room: %d",
                                monster, i + 1
                        );
                        break adventure;
                    }
            }
        }
        if (health > 0) {
            System.out.printf(
                    "You've made it!%n" +
                    "Bitcoins: %d%n" +
                    "Health: %d",
                    bitcoins, health
            );
        }
    }
}
