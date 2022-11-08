package lesson01_working_with_abstraction.exercise.n04_traffic_lights;

public class TrafficLight {
    private SignalColor signalColor;

    public TrafficLight(SignalColor color) {
        this.signalColor = color;
    }

    public String getSignalColor() {
        return signalColor.name();
    }

    public void switchSignal() {
        this.signalColor = this.signalColor.next();
    }
}
