package lesson05_polymorphism.exercise.n01_vehicles.vehicles;

import lesson05_polymorphism.exercise.n01_vehicles.exceptions.IllegalVehicleArgumentException;

import java.util.*;

public class AirConditionedVehicleRepository {
    private static final String VEHICLE_ALREADY_EXISTS_FORMAT = "Vehicle with such type already exists: %s";
    private static final String NOT_EXISTING_VEHICLE_MESSAGE = "Vehicle with such type does not exist in the repository!";

    private final Map<String, AirConditionedVehicle> vehicleMap;

    public AirConditionedVehicleRepository() {
        this.vehicleMap = new LinkedHashMap<>();
    }

    public void add(AirConditionedVehicle vehicle) {
        String type = vehicle.getType();
        if (vehicleMap.containsKey(type)) {
            throw new IllegalVehicleArgumentException(String.format(VEHICLE_ALREADY_EXISTS_FORMAT, type));
        }
        vehicleMap.put(type, vehicle);
    }

    public void addFromConsole(Scanner scanner) {

        String[] vehicleData = scanner.nextLine().split("\\s+");

        String type = vehicleData[0];
        double fuel = Double.parseDouble(vehicleData[1]);
        double consumption = Double.parseDouble(vehicleData[2]);

        AirConditionedVehicle vehicle = AirConditionedVehicleFactory.construct(type, fuel, consumption);
        this.add(vehicle);
    }

    public AirConditionedVehicle get(String vehicleType) {
        if (!vehicleMap.containsKey(vehicleType)) {
            throw new IllegalVehicleArgumentException(NOT_EXISTING_VEHICLE_MESSAGE);
        }
        return vehicleMap.get(vehicleType);
    }

    public Collection<AirConditionedVehicle> getAll() {
        return Collections.unmodifiableCollection(vehicleMap.values());
    }
}
