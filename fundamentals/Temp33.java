import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Temp33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String notDigit = "00";



        for (int i = 0; i < n ; i++) {
            StringBuilder codBilder = new StringBuilder();
            String imput = scanner.nextLine();
            String regex = "(@[#]+)(?<word>[A-Z][A-Za-z0-9]{4,}[A-Z])(@#+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(imput);
            boolean isDigit = false;
            if (matcher.find()){
                String cod = matcher.group("word");
                for (char symbol : cod.toCharArray() ) {
                    if (Character.isDigit(symbol)){
                        isDigit = true;
                        codBilder.append(symbol);
                    }
                }
                if (isDigit){
                    System.out.printf("Product group: %s%n", codBilder);
                }else {
                    System.out.printf("Product group: %s%n", notDigit);
                }
            }else {
                System.out.println("Invalid barcode");
            }


        }
    }
}
