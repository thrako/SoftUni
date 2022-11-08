package lesson01_working_with_abstraction.exercise.n04_traffic_lights;

public enum SignalColor {
    RED, GREEN, YELLOW;

    public SignalColor next() {
        return SignalColor.values()[(this.ordinal() + 1) % values().length];
    }
}
