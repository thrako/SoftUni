package lesson05_polymorphism.exercise.n02_vehicles_extension.vehicles;

import java.util.HashMap;
import java.util.Map;

public class AirConditionedVehicleFactory {

    private static final String UNKNOWN_VEHICLE_MSG_FORMAT = "Unknown vehicle type: %s";
    private static final Map<String, TriFunction<Double, Double, Double, AirConditionedVehicle>> VEHICLES = new HashMap<>();

    static  {
        VEHICLES.put("Bus", Bus::new);
        VEHICLES.put("Car", Car::new);
        VEHICLES.put("Truck", Truck::new);
    }

    @FunctionalInterface
    private interface TriFunction<T1, T2, T3, R> {
        R apply(T1 t1, T2 t2, T3 t3);
    }

    public static AirConditionedVehicle construct(String vehicleType,
                                                  double fuelQuantity,
                                                  double fuelConsumption,
                                                  double tankCapacity) {

        if (!VEHICLES.containsKey(vehicleType)) {
            throw new IllegalArgumentException(String.format(UNKNOWN_VEHICLE_MSG_FORMAT, vehicleType));
        }

        return VEHICLES.get(vehicleType).apply(fuelQuantity, fuelConsumption, tankCapacity);
    }

}
