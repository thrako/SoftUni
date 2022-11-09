package lesson08_text_processing.more;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class N04MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> morseEng = getMorseEngMap();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(morseEng::get)
                .forEach(System.out::print);
    }

    private static Map<String, String> getMorseEngMap() {
        Map<String, String> morseEng = new HashMap<>();
        morseEng.put(".-",   "A");
        morseEng.put("-...", "B");
        morseEng.put("-.-.",  "C");
        morseEng.put("-..",  "D");
        morseEng.put(".",    "E");
        morseEng.put("..-.", "F");
        morseEng.put("--.",  "G");
        morseEng.put("....", "H");
        morseEng.put("..",   "I");
        morseEng.put(".---", "J");
        morseEng.put("-.-",  "K");
        morseEng.put(".-..", "L");
        morseEng.put("--",   "M");
        morseEng.put("-.",   "N");
        morseEng.put("---",  "O");
        morseEng.put(".--.", "P");
        morseEng.put("--.-", "Q");
        morseEng.put(".-.",  "R");
        morseEng.put("...",  "S");
        morseEng.put("-",    "T");
        morseEng.put("..-",  "U");
        morseEng.put("...-", "V");
        morseEng.put(".--",  "W");
        morseEng.put("-..-", "X");
        morseEng.put("-.--", "Y");
        morseEng.put("--..", "Z");
        morseEng.put("-----", "0");
        morseEng.put(".----", "1");
        morseEng.put("..---", "2");
        morseEng.put("...--", "3");
        morseEng.put("....-", "4");
        morseEng.put(".....", "5");
        morseEng.put("-....", "6");
        morseEng.put("--...", "7");
        morseEng.put("---..", "8");
        morseEng.put("----.", "9");
        morseEng.put("|", " ");
        return morseEng;
    }
}
