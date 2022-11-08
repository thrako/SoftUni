package lesson06_defining_classes.exercise.N04RawData;

class Car {
    private static final int TIRES_COUNT = 4;
    private final String model;
    private final Engine engine;
    private final Cargo cargo;
    private final Tire[] tires = new Tire[TIRES_COUNT];

    public Car(String[] data) {
        int counter = -1;
        this.model = data[++counter];
        this.engine = new Engine(
                /*speed*/ Integer.parseInt(data[++counter]),
                /*power*/ Integer.parseInt(data[++counter]));
        this.cargo = new Cargo(
                /*weight*/ Integer.parseInt(data[++counter]),
                /*type*/ data[++counter]);
        for (int i = 0; i < TIRES_COUNT; i++) {
            this.tires[i] = new Tire(
                    /*pressure*/ Double.parseDouble(data[++counter]),
                    /*age*/ Integer.parseInt(data[++counter]));
        }
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Engine getEngine() {
        return engine;
    }

    public Tire[] getTires() {
        return tires;
    }

    @Override
    public String toString() {
        return this.model;
    }
}
