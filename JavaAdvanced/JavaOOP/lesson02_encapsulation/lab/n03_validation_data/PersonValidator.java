package lesson02_encapsulation.lab.n03_validation_data;

import java.text.DecimalFormat;

public class PersonValidator {
    private static final int MIN_FIRST_NAME_LENGTH = 3;
    private static final int MIN_LAST_NAME_LENGTH = 3;
    private static final double MIN_SALARY = 460.00;

    private static final String FIRST_NAME_LESS_THAN_REQUIRED_FORMAT = "First name cannot be less than %d symbols";
    private static final String LAST_NAME_LESS_THAN_REQUIRED_FORMAT = "Last name cannot be less than %d symbols";
    private static final String AGE_NEGATIVE_OR_ZERO_MSG = "Age cannot be zero or negative integer";
    private static final String SALARY_LESS_THAN_REQUIRED_FORMAT = "Salary cannot be less than %s leva";

    public static void validateFirstName(String name) {
        if (name.length() < MIN_FIRST_NAME_LENGTH) {
            final String message = String.format(FIRST_NAME_LESS_THAN_REQUIRED_FORMAT, MIN_FIRST_NAME_LENGTH);
            throw new IllegalPersonArgumentException(message);
        }
    }

    public static void validateLastName(String name) {
        if (name.length() < MIN_LAST_NAME_LENGTH) {
            final String message = String.format(LAST_NAME_LESS_THAN_REQUIRED_FORMAT, MIN_LAST_NAME_LENGTH);
            throw new IllegalPersonArgumentException(message);
        }
    }

    public static void validateAge(int age) {
        if (age <= 0) {
            throw new IllegalPersonArgumentException(AGE_NEGATIVE_OR_ZERO_MSG);
        }
    }

    public static void validateSalary(double salary) {
        if (salary < MIN_SALARY) {
            final DecimalFormat decimalFormat = new DecimalFormat("#.##");
            final String message = String.format(SALARY_LESS_THAN_REQUIRED_FORMAT, decimalFormat.format(MIN_SALARY));
            throw new IllegalPersonArgumentException(message);
        }
    }

}
