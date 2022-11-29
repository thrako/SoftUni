package lesson05_polymorphism.exercise.n02_vehicles_extension;

import lesson05_polymorphism.exercise.n02_vehicles_extension.comands.Command;
import lesson05_polymorphism.exercise.n02_vehicles_extension.comands.CommandFactory;
import lesson05_polymorphism.exercise.n02_vehicles_extension.exceptions.VehicleException;
import lesson05_polymorphism.exercise.n02_vehicles_extension.vehicles.AirConditionedVehicle;
import lesson05_polymorphism.exercise.n02_vehicles_extension.vehicles.AirConditionedVehicleFactory;
import lesson05_polymorphism.exercise.n02_vehicles_extension.vehicles.AirConditionedVehicleRepository;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final AirConditionedVehicleRepository vehicleRepository = new AirConditionedVehicleRepository();

        int vehiclesCount = 3;
        while (vehiclesCount-- > 0) {
            final AirConditionedVehicle vehicle = getVehicleFromConsole(scanner);
            vehicleRepository.add(vehicle);
        }

        int commandsCount = Integer.parseInt(scanner.nextLine());
        while (commandsCount-- > 0) {
            final String[] commandData = scanner.nextLine().split("\\s+");
            final String commandType = commandData[0];
            final String vehicleType = commandData[1];
            final double argument = Double.parseDouble(commandData[2]);

            final Command command = CommandFactory.construct(commandType, argument);
            final AirConditionedVehicle vehicle = vehicleRepository.get(vehicleType);

            try {
                command.executeOn(vehicle);
            } catch (VehicleException e) {
                System.out.println(e.getMessage());
            }
        }

        vehicleRepository.getAll().forEach(Main::printRemainingFuel);
    }

    private static AirConditionedVehicle getVehicleFromConsole(Scanner scanner) {
        final String[] vehicleData = scanner.nextLine().split("\\s+");
        final String vehicleType = vehicleData[0];
        final double fuelQuantity = Double.parseDouble(vehicleData[1]);
        final double fuelConsumption = Double.parseDouble(vehicleData[2]);
        final double tankCapacity = Double.parseDouble(vehicleData[3]);

        return AirConditionedVehicleFactory.construct(vehicleType, fuelQuantity, fuelConsumption, tankCapacity);
    }

    private static void printRemainingFuel(AirConditionedVehicle vehicle) {
        System.out.println(vehicle.getRemainingFuelMessage());
    }
}
