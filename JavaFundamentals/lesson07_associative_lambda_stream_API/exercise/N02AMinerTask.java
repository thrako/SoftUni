package lesson07_associative_lambda_stream_API.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class N02AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Long> resourceQty = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            String resource = input;
            Long qty = Long.parseLong(scanner.nextLine());
            resourceQty.put(resource, resourceQty.containsKey(resource)
                    ? resourceQty.get(resource) + qty
                    : qty
            );
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Long> entry : resourceQty.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
