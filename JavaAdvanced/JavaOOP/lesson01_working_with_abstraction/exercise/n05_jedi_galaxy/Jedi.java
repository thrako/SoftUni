package lesson01_working_with_abstraction.exercise.n05_jedi_galaxy;

public class Jedi {
    private long points = 0;

    public long getPoints() {
        return points;
    }

    public void collectStars(int[][] galaxy, int[] startingPosition) {
        int rowPlayer = startingPosition[0];
        int colPlayer = startingPosition[1];
        int rows = galaxy.length;
        int columns = galaxy[0].length;

        while (rowPlayer >= 0 && colPlayer < columns) {
            if (rowPlayer < rows && colPlayer >= 0) {
                points += galaxy[rowPlayer][colPlayer];
            }
            colPlayer++;
            rowPlayer--;
        }
    }
}
