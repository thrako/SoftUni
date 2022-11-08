package lesson03_sets_and_maps_advanced.lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class N02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> vipList = new TreeSet<>();
        Set<String> guestList = new TreeSet<>();
        String input = scanner.nextLine();
        while (!"PARTY".equals(input)) {
            if (Character.isDigit(input.charAt(0))) vipList.add(input);
            else guestList.add(input);
            input = scanner.nextLine();
        }
        while (!"END".equals(input)) {
            if (Character.isDigit(input.charAt(0))) vipList.remove(input);
            else guestList.remove(input);
            input = scanner.nextLine();
        }
        System.out.println((vipList.size() + guestList.size()));
        for (String vipGuest : vipList) {
            System.out.println(vipGuest);
        }
        for (String guest : guestList) {
            System.out.println(guest);
        }
    }
}
