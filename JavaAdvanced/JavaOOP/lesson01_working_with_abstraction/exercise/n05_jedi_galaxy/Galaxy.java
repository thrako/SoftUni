package lesson01_working_with_abstraction.exercise.n05_jedi_galaxy;

public class Galaxy {
    private final int[][] board;

    public Galaxy(int rows, int columns) {
        int[][] board = new int[rows][columns];
        int value = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                board[r][c] = value++;
            }
        }
        this.board = board;
    }

    public int[][] getBoard() {
        return board;
    }
}
