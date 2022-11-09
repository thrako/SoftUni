package lesson08_text_processing.more;

import java.util.Scanner;

public class N05HTML {
    private static final String END = "end of comments";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder strBld = new StringBuilder();

        String article = scanner.nextLine();
        strBld.append("<h1>\n    ").append(article).append("\n</h1>\n");

        String content = scanner.nextLine();
        strBld.append("<article>\n    ").append(content).append("\n</article>\n");

        String input = scanner.nextLine();
        while(!END.equals(input)) {
            strBld.append("<div>\n    ").append(input).append("\n</div>\n");
            input = scanner.nextLine();
        }

        System.out.println(strBld);
    }
}
