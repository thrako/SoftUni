package lesson05_polymorphism.exercise.n01_vehicles;

import lesson05_polymorphism.exercise.n01_vehicles.exceptions.VehicleException;
import lesson05_polymorphism.exercise.n01_vehicles.comands.Command;
import lesson05_polymorphism.exercise.n01_vehicles.comands.CommandFactory;
import lesson05_polymorphism.exercise.n01_vehicles.vehicles.AirConditionedVehicle;
import lesson05_polymorphism.exercise.n01_vehicles.vehicles.AirConditionedVehicleRepository;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AirConditionedVehicleRepository repository = new AirConditionedVehicleRepository();

        int vehiclesCount = 2;
        while (vehiclesCount-- > 0) {
            repository.addFromConsole(scanner);
        }

        int commandsCount = Integer.parseInt(scanner.nextLine());
        while (commandsCount-- > 0) {
            String[] commandData = scanner.nextLine().split("\\s+");

            Command command = getCommand(commandData);
            AirConditionedVehicle vehicle = getVehicle(repository, commandData);

            try {
                command.executeOn(vehicle);
            } catch (VehicleException e) {
                System.out.println(e.getMessage());
            }
        }

        repository.getAll().forEach(Main::printRemainingFuel);
    }

    private static Command getCommand(String[] commandData) {
        String commandType = commandData[0];
        double argument = Double.parseDouble(commandData[2]);

        return CommandFactory.construct(commandType, argument);
    }

    private static AirConditionedVehicle getVehicle(AirConditionedVehicleRepository repository, String[] commandData) {
        String vehicleType = commandData[1];
        return repository.get(vehicleType);
    }

    private static void printRemainingFuel(AirConditionedVehicle vehicle) {
        System.out.println(vehicle.getRemainingFuelMessage());
    }
}
