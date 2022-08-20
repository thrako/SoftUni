package lesson02_multidimensional_arrays.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class N08TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double playerAttack = Double.parseDouble(scanner.nextLine());
        Arena arena = new Arena();
        Player player = new Player(playerAttack);
        Boss heigan = new Boss();
        while (player.isAlive() && heigan.isAlive()) {
            processTurn(arena, player, heigan, scanner);
        }

        System.out.println((heigan.isAlive()
                ? String.format("Heigan: %.2f", heigan.getHealth())
                : "Heigan: Defeated!"));

        System.out.println(player.isAlive()
                ? String.format("Player: %d", player.getHealth())
                : String.format("Player: Killed by %s", heigan.getLastSpell()));

        System.out.printf("Final position: %d, %d%n", player.getPosition("row"), player.getPosition("col"));

    }

    private static void processTurn(Arena arena, Player player, Boss heigan, Scanner scanner) {
        heigan.takeDamage(player.getAttack());
        if (player.isPoisoned()) {
            player.takeDamage(Boss.CLOUD_DAMAGE);
            if (!player.isAlive()) {
                heigan.setLastSpell("Cloud");
                return;
            }
        }
        if (heigan.isAlive()) {
            String[] spellData = scanner.nextLine().split("\\s+");
            String spellName = spellData[0];
            int targetRow = Integer.parseInt(spellData[1]);
            int targetColumn = Integer.parseInt(spellData[2]);
            heigan.setLastSpell(spellName);
            arena.setAffectedArea(targetRow, targetColumn);
            if (arena.isAffected(player.getPosition("row"), player.getPosition("col")))
                if (!player.move(arena)) {
                    switch (spellName) {
                        case "Cloud":
                            player.increasePoisonDuration(Boss.CLOUD_DURATION);
                            player.takeDamage(Boss.CLOUD_DAMAGE);
                            break;
                        case "Eruption":
                            player.takeDamage(Boss.ERUPTION_DAMAGE);
                    }

                }
            arena.unsetAffectedArea(targetRow, targetColumn);
        }
        player.decreasePoisonDuration();
    }

    private static class Arena {
        private final int SIDE = 15;
        private final boolean[][] matrix = new boolean[SIDE][SIDE];

        public Arena() {
        }

        public void setAffectedArea(int row, int column) {
            for (int r = row - 1; r <= row + 1; r++) {
                for (int c = column - 1; c <= column + 1; c++) {
                    if (isInRange(r, c)) {
                        matrix[r][c] = true;
                    }
                }
            }
        }

        private boolean isInRange(int r, int c) {
            return r >= 0 && r < SIDE && c >= 0 && c < SIDE;
        }

        public void unsetAffectedArea(int row, int column) {
            for (int r = row - 1; r <= row + 1; r++) {
                for (int c = column - 1; c <= column + 1; c++) {
                    if (isInRange(r, c)) {
                        matrix[r][c] = false;
                    }
                }
            }
        }

        public boolean isAffected(int r, int c) {
            return matrix[r][c];
        }
    }

    private static class Player {
        private final Map<String, Integer> position = new HashMap<>();
        private final double attack;
        private int health = 18_500;
        private int poisonDuration = 0;

        public Player(double attack) {
            this.attack = attack;
            position.put("row", 7);
            position.put("col", 7);
        }

        public boolean isAlive() {
            return this.health > 0;
        }

        public double getAttack() {
            return this.attack;
        }

        public int getHealth() {
            return health;
        }

        public void takeDamage(int damage) {
            this.health = this.health - damage;
        }

        public boolean isPoisoned() {
            return poisonDuration > 0;
        }

        public void increasePoisonDuration(int i) {
            this.poisonDuration += i;
        }

        public void decreasePoisonDuration() {
            if (this.poisonDuration > 0) this.poisonDuration--;
        }

        public Integer getPosition(String key) {
            return position.get(key);
        }

        public boolean move(Arena arena) {
            int row = this.position.get("row");
            int col = this.position.get("col");

            if (isValidMove(arena, row - 1, col)) {
                this.position.put("row", row - 1); //go up
                return true;
            }

            if (isValidMove(arena, row, col + 1)) {
                this.position.put("col", col + 1); //go right
                return true;
            }

            if (isValidMove(arena, row + 1, col)) {
                this.position.put("row", row + 1); //go down
                return true;
            }

            if (isValidMove(arena, row, col - 1)) {
                this.position.put("col", col - 1); //go left
                return true;
            }

            return false;
        }

        private boolean isValidMove(Arena arena, int row, int col) {
            return arena.isInRange(row, col) && !arena.isAffected(row, col);
        }
    }

    private static class Boss {
        private static final int CLOUD_DAMAGE = 3_500;
        private static final int CLOUD_DURATION = 2;
        private static final int ERUPTION_DAMAGE = 6_000;
        private double health = 3_000_000;
        private String lastSpell = "";

        public Boss() {
        }

        public boolean isAlive() {
            return this.health > 0;
        }

        public double getHealth() {
            return health;
        }

        public void takeDamage(double attack) {
            this.health -= attack;
        }

        public String getLastSpell() {
            //noinspection EnhancedSwitchMigration
            switch (this.lastSpell) {
                case "Cloud":
                    return "Plague Cloud";
                case "Eruption":
                    return "Eruption";
                default:
                    return "";
            }
        }

        public void setLastSpell(String lastSpell) {
            this.lastSpell = lastSpell;
        }
    }

}
