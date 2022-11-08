package lesson02_multidimensional_arrays.exercise;

import java.util.*;
import java.util.stream.Collectors;

public class N10RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game(scanner);
        game.play();
        
    }

    private static class Game {
        private Character[][] matrix;
        private int rows;
        private int columns;
        private Player player;
        private boolean gameOver = false;
        private boolean gameWon = false;
        private final List<int[]> adjacentCells = new ArrayList<>();

        public Game(Scanner scanner) {
            this.init(scanner);
        }

        private void init(Scanner scanner) {
            this.player = new Player();

            int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            this.rows = dimensions[0];
            this.columns = dimensions[1];
            this.matrix = new Character[this.rows][];
            for (int r = 0; r < this.rows; r++) {
                this.matrix[r] = scanner.nextLine().chars()
                        .mapToObj(ch -> (char) ch)
                        .toArray(Character[]::new);
                for (int c = 0; c < columns; c++) {
                    if (matrix[r][c] == 'P') this.player.setPosition(r, c);
                }
            }

            this.player.initMoves(scanner);
        }

        private void play() {
            while (!this.gameOver) {
                processTurn();
            }
            for (Character[] row : matrix) {
                System.out.println(Arrays.stream(row)
                        .map(String::valueOf)
                        .collect(Collectors.joining("")));
            }
            System.out.printf("%s: %d %d%n",
                    (gameWon) ? "won" : "dead",
                    player.getPosRow(),
                    player.getPosCol());
        }

        private void processTurn() {
            this.movePlayer();
            this.spreadBunnies();
        }

        private void movePlayer() {
            int currRow = this.player.getPosRow();
            int currCol = this.player.getPosCol();
            this.matrix[currRow][currCol] = '.';
            
            int newRow = currRow;
            int newCol = currCol;            
            switch (this.player.nextMove()) {
                case 'U':
                    --newRow;
                    break;
                case 'D':
                    ++newRow;
                    break;
                case 'L':
                    --newCol;
                    break;
                case 'R':
                    ++newCol;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + player.nextMove());
            }

            if (isInRange(newRow, newCol)) {
                this.player.setPosition(newRow, newCol);
                if (isBunny(newRow, newCol)) {
                    this.gameOver = true;
                } else {
                    this.matrix[newRow][newCol] = 'P';
                }
            } else {
                this.gameOver = true;
                this.gameWon = true;
            }
        }
        
        private void spreadBunnies() {
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < columns; c++) {
                    if (isBunny(r, c)) {
                        addAdjacentIfValid(r - 1, c);
                        addAdjacentIfValid(r + 1, c);
                        addAdjacentIfValid(r, c - 1);
                        addAdjacentIfValid(r, c + 1);
                    }
                }
            }

            for (int[] adjCell : adjacentCells) {
                if (isPlayer(adjCell[0], adjCell[1])) {
                    this.gameOver = true;
                }
                this.matrix[adjCell[0]][adjCell[1]] = 'B';
            }
            adjacentCells.clear();

        }

        private void addAdjacentIfValid(int adjRow, int adjCol) {
            if (isInRange(adjRow, adjCol) && !isBunny(adjRow, adjCol)) this.adjacentCells.add(new int[] {adjRow, adjCol});
        }

        private boolean isPlayer(int r, int c) {
            return matrix[r][c] == 'P';
        }

        private boolean isBunny(int r, int c) {
            return this.matrix[r][c] == 'B';
        }

        private boolean isInRange(int r, int c) {
            return r >= 0 && r < this.rows && c >= 0 && c < this.columns;
        }
    }

    private static class Player {
        private final Map<String, Integer> position = new HashMap<>();
        private final Queue<Character> moves = new ArrayDeque<>();

        public Player() {
        }

        private void initMoves(Scanner scanner) {
            scanner.nextLine().chars()
                    .mapToObj(ch -> (char) ch)
                    .forEach(moves::offer);
        }

        private Character nextMove() {
            return moves.poll();
        }

        public Integer getPosRow() {
            return position.get("row");
        }

        public Integer getPosCol() {
            return position.get("col");
        }

        public void setPosition(int r, int c) {
            this.position.put("row", r);
            this.position.put("col", c);
        }
    }
}

