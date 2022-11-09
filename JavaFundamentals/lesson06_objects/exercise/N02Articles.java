package lesson06_objects.exercise;

import java.util.Scanner;

public class N02Articles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lineInputs = scanner.nextLine().split(", ");
        Article article = new Article(lineInputs);

        int operationsCount = Integer.parseInt(scanner.nextLine());
        String[] tokens;
        for (int i = 0; i < operationsCount; i++) {
            tokens = scanner.nextLine().split(": ");
            String command = tokens[0];
            String data = tokens[1];
            switch (command) {
                case "Edit":
                    article.edit(data);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(data);
                    break;
                case "Rename":
                    article.rename(data);
                    break;
            }
        }
        System.out.println(article);
    }

    private static class Article {
        private String title;
        private String content;
        private String author;

        public Article(String[] args) {
            this.title = args[0];
            this.content = args[1];
            this.author = args[2];
        }

        public void edit(String content) {
            this.content = content;
        }

        public void changeAuthor(String author) {
            this.author = author;
        }

        public void rename(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s",
                    this.title,
                    this.content,
                    this.author);
        }
    }
}


