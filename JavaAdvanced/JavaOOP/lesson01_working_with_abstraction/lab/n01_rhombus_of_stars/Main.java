package lesson01_working_with_abstraction.lab.n01_rhombus_of_stars;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int side = Integer.parseInt(scanner.nextLine());
        ConsoleDrawer drawer = new ConsoleDrawer();
        drawer.drawRhombus(side);
    }
}

class ConsoleDrawer {

    private static final char DEFAULT_SYMBOL = '*';
    private static final String SPACE = " ";

    private char symbol;

    public void drawRhombus(int side) {
        drawRhombus(side, DEFAULT_SYMBOL);
    }

    public void drawTriangle(int side) {
        drawTriangle(side, DEFAULT_SYMBOL);
    }

    public void drawRhombus(int side, char symbol) {
        this.symbol = symbol;
        int starsCount = 0;
        while (++starsCount < side) {
            drawIndentedLine(starsCount, side);
        }
        while (starsCount > 0) {
            drawIndentedLine(starsCount, side);
            starsCount--;
        }
    }

    public void drawTriangle(int side, char symbol) {
        this.symbol = symbol;
        int starsCount = 0;
        while (++starsCount <= side) {
            drawIndentedLine(starsCount, side);
        }
    }

    private void drawIndentedLine(int symbolsCount, int side) {
        int indent = side - symbolsCount;
        StringBuilder stringBuilder = new StringBuilder();

        while (indent-- > 0) {
            stringBuilder.append(SPACE);
        }
        while (symbolsCount-- > 0) {
            stringBuilder.append(symbol).append(SPACE);
        }
        System.out.println(stringBuilder);
    }
}
