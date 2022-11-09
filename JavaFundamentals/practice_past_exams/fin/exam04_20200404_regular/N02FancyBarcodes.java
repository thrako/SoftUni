package practice_past_exams.fin.exam04_20200404_regular;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N02FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLines = Integer.parseInt(scanner.nextLine());
        Pattern barcodePattern = Pattern.compile("^@[#]+(?<word>[A-Z][A-Za-z0-9]{4,}[A-Z])@[#]+$");
        Pattern digitPattern = Pattern.compile("(?<d>[\\d]+)");
        for (int i = 0; i < numLines; i++) {
            Matcher matcher = barcodePattern.matcher(scanner.nextLine());
            StringBuilder strBld = new StringBuilder();
            if (matcher.find()) {
                String word = matcher.group("word");
                matcher = digitPattern.matcher(word);
                while (matcher.find()) strBld.append(matcher.group("d"));
                if (strBld.length() == 0) strBld.append("00");
                System.out.printf("Product group: %s%n", strBld);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
