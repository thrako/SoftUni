package lesson04_interfaces.exercise.n05_telephony;

import java.util.List;
import java.util.stream.Collectors;

public class Smartphone
        implements Callable, Browsable {

    private final List<String> numbers;
    private final List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    public String call() {
        return numbers.stream()
                .map(this::processNumber)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String processNumber(String number) {
        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)) {
                return "Invalid number!";
            }
        }
        return String.format("Calling... %s", number);
    }

    public String browse() {
        return urls.stream()
                .map(this::processURL)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String processURL(String url) {
        for (char c : url.toCharArray()) {
            if (Character.isDigit(c)) {
                return "Invalid URL!";
            }
        }
        return String.format("Browsing: %s!", url);
    }
}
