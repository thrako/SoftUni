package lesson01_basic_syntax.more;

import java.util.Scanner;

public class N05Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLines = Integer.parseInt(scanner.nextLine());
        String msg = "";

        for (int i = 0; i < numLines; i++) {
            String symb;
            int input = Integer.parseInt(scanner.nextLine());
            switch (input) {
                case 2:
                    symb = "a";
                    break;
                case 22:
                    symb = "b";
                    break;
                case 222:
                    symb = "c";
                    break;
                case 3:
                    symb = "d";
                    break;
                case 33:
                    symb = "e";
                    break;
                case 333:
                    symb = "f";
                    break;
                case 4:
                    symb = "g";
                    break;
                case 44:
                    symb = "h";
                    break;
                case 444:
                    symb = "i";
                    break;
                case 5:
                    symb = "j";
                    break;
                case 55:
                    symb = "k";
                    break;
                case 555:
                    symb = "l";
                    break;
                case 6:
                    symb = "m";
                    break;
                case 66:
                    symb = "n";
                    break;
                case 666:
                    symb = "o";
                    break;
                case 7:
                    symb = "p";
                    break;
                case 77:
                    symb = "q";
                    break;
                case 777:
                    symb = "r";
                    break;
                case 7777:
                    symb = "s";
                    break;
                case 8:
                    symb = "t";
                    break;
                case 88:
                    symb = "u";
                    break;
                case 888:
                    symb = "v";
                    break;
                case 9:
                    symb = "w";
                    break;
                case 99:
                    symb = "x";
                    break;
                case 999:
                    symb = "y";
                    break;
                case 9999:
                    symb = "z";
                    break;
                case 0:
                    symb = " ";
                    break;
                default:
                    symb = "";
            }
            msg = msg.concat(symb);
        }
        System.out.println(msg);
    }
}

