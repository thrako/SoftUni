package practice_past_exams.fin.exam01_20200815_retake;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class N03ThePianist {
    private static final String END = "Stop";

    public static void main(String[] args) {
        Map<String, Piece> pieceMap = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        String[] tokens;
        String name, composer, key;
        for (int i = 0; i < count; i++) {
            tokens = scanner.nextLine().split("\\|");
            name = tokens[0];
            composer = tokens[1];
            key = tokens[2];
            pieceMap.putIfAbsent(name, new Piece(name, composer, key));
        }

        tokens = scanner.nextLine().split("\\|");
        while (!END.equals(tokens[0])) {
            switch (tokens[0]) {
                case "Add":
                    name = tokens[1];
                    if (!pieceMap.containsKey(name)) {
                        composer = tokens[2];
                        key = tokens[3];
                        pieceMap.put(name, new Piece(name, composer, key));
                        System.out.printf("%s by %s in %s added to the collection!%n", name, composer, key);
                    } else {
                        System.out.printf("%s is already in the collection!%n", name);
                    }
                    break;
                case "Remove":
                    name = tokens[1];
                    if (pieceMap.containsKey(name)) {
                        pieceMap.remove(name);
                        System.out.printf("Successfully removed %s!%n", name);
                    }
                    else System.out.printf("Invalid operation! %s does not exist in the collection.%n", name);
                    break;
                case "ChangeKey":
                    name = tokens[1];
                    Piece piece = pieceMap.get(name);
                    if (piece != null) {
                        key = tokens[2];
                        piece.setKey(key);
                        System.out.printf("Changed the key of %s to %s!%n", name, key);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", name);
                    }
                    break;
                default:
            }

            tokens = scanner.nextLine().split("\\|");
        }
        pieceMap.values().forEach(System.out::println);
    }

    private static class Piece {
        private final String name;
        private final String composer;
        private String key;

        public Piece(String name, String composer, String key) {
            this.name = name;
            this.composer = composer;
            this.key = key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return String.format("%s -> Composer: %s, Key: %s", name, composer, key);
        }
    }
}
