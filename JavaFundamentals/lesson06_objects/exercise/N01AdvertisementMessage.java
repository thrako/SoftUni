package lesson06_objects.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class N01AdvertisementMessage {
    public static void main(String[] args) {
        String[] phrases = {
                "Excellent product.",
                "Such a great product.",
                "I always use that product.",
                "Best product of its category.",
                "Exceptional product.",
                "I can’t live without this product.",
        };
        String[] events = {
                "Now I feel good.",
                "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.",
                "I feel great!",
        };
        String[] authors = {
                "Diana",
                "Petya",
                "Stella",
                "Elena",
                "Katya",
                "Iva",
                "Annie",
                "Eva",
        };
        String[] cities = {
                "Burgas",
                "Sofia",
                "Plovdiv",
                "Varna",
                "Ruse",
        };
        Container msgContainer = new Container(phrases, events, authors, cities);
        Scanner scanner = new Scanner(System.in);
        int msgCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < msgCount; i++) {
            System.out.println(msgContainer.getRandomMsg());
        }
    }

    private static class Container {
        private final List<String> phrases;
        private final List<String> events;
        private final List<String> authors;
        private final List<String> cities;

        public Container(String[] phrases, String[] events, String[] authors, String[] cities) {
            this.phrases = Arrays.asList(phrases);
            this.events = Arrays.asList(events);
            this.authors = Arrays.asList(authors);
            this.cities = Arrays.asList(cities);
        }

        public String getRandomMsg() {
            Random rnd = new Random();
            String randomPhrase = this.phrases.get(rnd.nextInt(this.phrases.size()));
            String randomEvent = this.events.get(rnd.nextInt(this.events.size()));
            String randomAuthor = this.authors.get(rnd.nextInt(this.authors.size()));
            String randomCity = this.cities.get(rnd.nextInt(this.cities.size()));
            return String.format(
                    "%s %s %s – %s",
                    randomPhrase, randomEvent, randomAuthor, randomCity
            );
        }
    }
}


