import java.math.BigInteger;

public class Temp {
    public static void main(String[] args) {
        int accNum =  12345678;
        String accIBAN = getIBAN(accNum);
        System.out.println(accIBAN);
    }

    private static String getIBAN(int accNum) {
        String countryCode = "BG";
        String controlNum = "00";
        String bicFirstFour = "AAAA";
        String baeCode = "1231";
        String accountType = "10";
        String accountNumber = String.format("%08d", accNum);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(bicFirstFour)
                .append(baeCode)
                .append(accountType)
                .append(accountNumber)
                .append(countryCode)
                .append(controlNum);

        String numericString = toNumChars(stringBuilder.toString());

        BigInteger mod97 = new BigInteger(numericString).mod(new BigInteger("97"));
        controlNum = String.format("%02d", (new BigInteger("98").subtract(mod97)));
        stringBuilder.setLength(0);
        stringBuilder
                .append(countryCode)
                .append(controlNum)
                .append(bicFirstFour)
                .append(baeCode)
                .append(accountType)
                .append(accountNumber);
        return stringBuilder.toString();
    }

    private static String toNumChars(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, length = input.length(); i < length; i++) {
            char symbol = input.charAt(i);
            if ('A' <= symbol && symbol <= 'Z') {
                int num = (int) symbol - 55;
                sb.append(String.format("%d", num));
            } else if ('0' <= symbol && symbol <= '9') {
                sb.append(symbol);
            }
        }
        return sb.toString();
    }

}
