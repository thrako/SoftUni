package lesson05_polymorphism.exercise.n02_vehicles_extension.vehicles;

public enum AirConditionedVehicleFactory {
    Bus(Bus::new),
    Car(Car::new),
    Truck(Truck::new)
    ;

    private final TriFunction<Double, Double, Double, AirConditionedVehicle> aNew;

    @FunctionalInterface
    interface TriFunction<T1, T2, T3, R> {
        R apply(T1 t1, T2 t2, T3 t3);
    }

    AirConditionedVehicleFactory(TriFunction<Double, Double, Double, AirConditionedVehicle> aNew) {
        this.aNew = aNew;
    }

    public static AirConditionedVehicle construct(String type, double fuel, double consumption, double capacity) {
        return AirConditionedVehicleFactory.valueOf(type).aNew.apply(fuel, consumption, capacity);
    }

}
