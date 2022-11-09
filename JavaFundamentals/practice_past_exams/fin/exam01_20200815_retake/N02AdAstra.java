package practice_past_exams.fin.exam01_20200815_retake;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N02AdAstra {
    private static final int KCAL_PER_DAY = 2_000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("(?<dlmt>[#|])(?<item>[A-Za-z\\s]+)\\k<dlmt>(?<exp>[\\d]{2}/[\\d]{2}/[\\d]{2})\\k<dlmt>(?<kcal>[\\d]+)\\k<dlmt>");
        Matcher matcher = pattern.matcher(input);
        List<Food> foods = new ArrayList<>();
        while (matcher.find()) {
            String name = matcher.group("item");
            String expDate = matcher.group("exp");
            int kcal = Integer.parseInt(matcher.group("kcal"));
            foods.add(new Food(name, expDate, kcal));
        }
        int totalKCal = foods.stream().map(Food::getKcal).reduce(Integer::sum).orElse(0);
        int days = totalKCal / KCAL_PER_DAY;
        System.out.printf("You have food to last you for: %d days!%n", days);
        foods.forEach(System.out::println);
    }

    private static class Food {
        private final String name;
        private final String expDate;
        private final int kcal;

        public Food(String name, String expDate, int kcal) {
            this.name = name;
            this.expDate = expDate;
            this.kcal = kcal;
        }

        public int getKcal() {
            return kcal;
        }

        @Override
        public String toString() {
            return String.format("Item: %s, Best before: %s, Nutrition: %d", name, expDate, kcal);
        }
    }
}
