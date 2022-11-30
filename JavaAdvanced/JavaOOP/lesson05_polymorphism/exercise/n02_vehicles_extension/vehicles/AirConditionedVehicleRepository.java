package lesson05_polymorphism.exercise.n02_vehicles_extension.vehicles;

import lesson05_polymorphism.exercise.n02_vehicles_extension.exceptions.IllegalVehicleArgumentException;

import java.util.*;

public class AirConditionedVehicleRepository {

    private static final String VEHICLE_ALREADY_EXISTS_FORMAT = "Vehicle with such type already exists: %s!";
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
