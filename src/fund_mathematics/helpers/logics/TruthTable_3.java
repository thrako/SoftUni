package helpers.logics;

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
public class TruthTable_3 {
    private static boolean[][] table;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of propositions (3)");
        int numPropositions = 3;
        int numRows = (int) Math.pow(2, numPropositions);
        int numCols = numPropositions;

        table = new boolean[numRows][numCols];
        fillTable(numRows, numCols);

        for (int row = 0; row < numRows; row++) {
            boolean p = table[row][0];
            boolean q = table[row][1];
            boolean r = table[row][2];

            // Докажете, че p → (q → r) → (p → q) → (p → r) е тавтология.
            boolean expression =
                    imply(p, imply(imply(q, r), imply(imply(p, q), imply(p, r))));
            System.out.println(expression);
        }

    }

    private static boolean imply(boolean a, boolean b) {
        return !a || b;
    }

    private static void fillTable(int numRows, int numCols) {

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {

                if (col == 0) {
                    if (row <= (numRows / 2) - 1) {
                        table[row][col] = true;
                    }

                } else if (col == 1) {
                    if (row == 0 || row == 1) {
                        table[row][col] = true;
                    } else {
                        if (table[row - 1][col] == table[row - 2][col]) {
                            table[row][col] = !table[row - 1][col];
                        } else {
                            table[row][col] = table[row - 1][col];
                        }
                    }
                } else {
                    if (row % 2 == 0) {
                        table[row][col] = true;
                    }
                }
            }
        }
    }
}
