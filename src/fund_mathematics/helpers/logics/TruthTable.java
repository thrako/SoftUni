package helpers.logics;

import java.util.Arrays;
import java.util.Scanner;

/*
(p)         твърдение;                 {T, F}
(~p)        отрицание на твърдение;    {!T, !F}
(p ^ q)     конюнкция;                 =(p && q)
(p v q)     дизюнкция;                 =(p || q)
                    Комутативност:              A ^ B = B ^ A
                                                A v B = B v A
                    Асоциативност:              (A ^ B) ^ C = A ^ (B ^ C)
                                                (A v B) v C = A v (B v C)
                    Закони на Де Морган:        ~(A ^ B) = (~A) v (~B)
                                                ~(A v B) = (~A) ^ (~B)
                    Дистрибутивност:            A ^ (B v C) = (A ^ B) v (A ^ C)
                                                A v (B ^ C) = (A v B) ^ (A v C)

                    Свойства на константите:    A v F = A
                                                A v T = T
                                                A ^ F = F
                                                A ^ T = A
                    Закони на поглъщането:      (A ^ B) v A = A
                                                (A v B) ^ A = A
                    Закон за противоречието:     А ^ (~A) = F

(p -> q)    импликация;                = ifThen(p, q) //if p, then q
(~q -> ~p)  контрапозиция
            (p -> q) = (~q -> ~p);
(q -> p)     конверсия;
(~p -> ~q)   инверсия;
            (q -> p) = (~p -> ~q);

(p <-> q)    еквивалентност;           =(p == q)
Закони за еквивалентността:
                А <-> B = B <-> A
                A <-> B = ~A <-> ~B
                A <-> B = (A -> B) ^ (B -> A)
                A <-> B = (A ^ B) v (~A ^ ~B)
*/
public class TruthTable {
    private static boolean[][] table;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of propositions: ");
        int numCols = Integer.parseInt(scanner.nextLine());
        int numRows = (int) Math.pow(2, numCols);
        table = new boolean[numRows][numCols];
        fillTable(numRows, numCols);
        printTable(numRows, numCols);
    }

    private static void printTable(int numRows, int numCols) {
        boolean p, q, r, s;
        p = q = r = s = false;

        printHeadings(numCols);
        for (int row = 0; row < numRows; row++) {
            if (numCols > 0) p = table[row][0];
            if (numCols > 1) q = table[row][1];
            if (numCols > 2) r = table[row][2];
            if (numCols > 3) s = table[row][3];

            boolean expression =
                    // (p ^ (p -> q)) -> q
                    imply(p && imply(p,q), q);

            System.out.print(Arrays.toString(table[row]));
            System.out.print(" --> " + expression);
            System.out.println();
        }
    }

    private static void printHeadings(int numCols) {
        if (numCols > 0) System.out.print("  (p)  ");
        if (numCols > 1) System.out.print("  (q)  ");
        if (numCols > 2) System.out.print("  (r)  ");
        if (numCols > 3) System.out.print("  (s)  ");
        if (numCols > 4) System.out.print("  (t)  ");
        if (numCols > 5) System.out.print("  (u)  ");
        if (numCols > 6) System.out.print("  (v)  ");
        if (numCols > 7) System.out.print("  (w)  ");
        if (numCols > 8) System.out.print("  (x)  ");
        if (numCols > 9) System.out.print("  (y)  ");

        System.out.print("--> exp");
        System.out.println();
    }

    private static boolean imply(boolean a, boolean b) {
        return !a || b;
    }

    private static void fillTable(int numRows, int numCols) {

        for (int i = 0; i < numRows; i++) {
            String binStr = Integer.toString(i, 2);
            for (int j = 0; j < binStr.length(); j++) {
                if (binStr.charAt(binStr.length() - 1 - j) == '1')
                    table[i][numCols - 1 - j] = true;
            }
        }
    }


}

