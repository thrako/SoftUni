package lesson06_objects.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N04Article2_0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Article2> articlesList = new ArrayList<>();
        int articlesCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < articlesCount; i++) {
            String[] data = scanner.nextLine().split(", ");
            articlesList.add(new Article2(data));
        }
        String lastInput = scanner.nextLine();
        for (Article2 article2 : articlesList) {
            System.out.print(article2);
        }
    }

    static class Article2 {
        private final String title;
        private final String content;
        private final String author;

        public Article2(String[] args) {
            this.title = args[0];
            this.content = args[1];
            this.author = args[2];
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s%n",
                    this.title,
                    this.content,
                    this.author);
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }
    }
}


