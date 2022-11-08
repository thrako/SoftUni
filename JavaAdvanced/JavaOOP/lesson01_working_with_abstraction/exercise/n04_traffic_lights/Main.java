package lesson01_working_with_abstraction.exercise.n04_traffic_lights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static List<TrafficLight> trafficLights;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initTrafficLights(scanner);
        int signalsCount = getSignalsCount(scanner);
        for (int i = 0; i < signalsCount; i++) {
            trafficLights.forEach(TrafficLight::switchSignal);
            System.out.println(getAllTrafficLightColors());
        }
    }

    private static int getSignalsCount(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static void initTrafficLights(Scanner scanner) {
        trafficLights = new ArrayList<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(Main::addNewTrafficLight);
    }

    private static void addNewTrafficLight(String color) {
        trafficLights.add(new TrafficLight(SignalColor.valueOf(color)));
    }

    private static String getAllTrafficLightColors() {
        return trafficLights.stream()
                .map(TrafficLight::getSignalColor)
                .collect(Collectors.joining(" "));
    }


}
