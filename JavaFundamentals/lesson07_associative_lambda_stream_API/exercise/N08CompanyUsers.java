package lesson07_associative_lambda_stream_API.exercise;

import java.util.*;

public class N08CompanyUsers {
    public static void main(String[] args) {
        Map<String, Set<String>> companyEmployees = new LinkedHashMap<>();
        consoleFill(companyEmployees);
        printFormatted(companyEmployees);
    }

    private static void printFormatted(Map<String, Set<String>> companyEmployees) {
        for (Map.Entry<String, Set<String>> entry : companyEmployees.entrySet()) {
            System.out.println(entry.getKey());
            Set<String> employeeIDs = entry.getValue();
            for (String empID : employeeIDs) {
                System.out.println("-- " + empID);
            }
        }
    }

    private static void consoleFill(Map<String, Set<String>> companyEmployees) {
        Scanner scanner = new Scanner(System.in);
        String company, employeeID, input = scanner.nextLine();
        String[] tokens;
        while (!"End".equals(input)) {
            tokens = input.split(" -> ");
            company = tokens[0];
            employeeID = tokens[1];

            companyEmployees.putIfAbsent(company, new LinkedHashSet<>());
            companyEmployees.get(company).add(employeeID);

            input = scanner.nextLine();
        }
    }
}
