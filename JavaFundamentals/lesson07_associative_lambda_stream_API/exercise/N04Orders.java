package lesson07_associative_lambda_stream_API.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class N04Orders {
    private static final String END = "buy";

    public static void main(String[] args) {
        Map<String, double[]> productsData = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        String name, input = scanner.nextLine();
        String[] tokens;
        double price, qty;

        while (!END.equals(input)) {
            tokens = input.split("\\s+");
            name = tokens[0];
            price = Double.parseDouble(tokens[1]);
            qty = Double.parseDouble(tokens[2]);
            productsData.putIfAbsent(name, new double[]{(double) 0, (double) 0});
            productsData.get(name)[0] = price;
            productsData.get(name)[1] += qty;
            input = scanner.nextLine();
        }

        double total;
        for (Map.Entry<String, double[]> entry : productsData.entrySet()) {
            total =  entry.getValue()[0] * entry.getValue()[1];
            System.out.printf("%s -> %.2f%n", entry.getKey(), total);
        }
    }
}
