package lesson01_working_with_abstraction.exercise.n05_jedi_galaxy;

public class Evil {
    public void destroyStars(int[][] galaxy, int[] startingPosition) {
        int rowEvil = startingPosition[0];
        int colEvil = startingPosition[1];
        int rows = galaxy.length;
        int columns = galaxy[0].length;

        while (rowEvil >= 0 && colEvil >= 0) {
            if (rowEvil < rows && colEvil < columns) {
                galaxy[rowEvil][colEvil] = 0;
            }
            rowEvil--;
            colEvil--;
        }
    }
}
