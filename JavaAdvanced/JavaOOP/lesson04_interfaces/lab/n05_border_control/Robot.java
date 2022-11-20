package lesson04_interfaces.lab.n05_border_control;

public class Robot implements Identifiable {
    private final String model;
    private final String id;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }
}
