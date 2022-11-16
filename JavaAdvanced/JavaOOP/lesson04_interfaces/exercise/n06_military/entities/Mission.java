package lesson04_interfaces.exercise.n06_military.entities;

import lesson04_interfaces.exercise.n06_military.enums.Formats;
import lesson04_interfaces.exercise.n06_military.enums.States;

public class Mission {
    private String codeName;
    private States state;

    public Mission(String codeName, States state) {
        this.codeName = codeName;
        this.state = state;
    }

    public String getCodeName() {
        return codeName;
    }

    public States getState() {
        return state;
    }

    public void completeMission() {
        this.state = States.finished;
    }

    @Override
    public String toString() {
        return Formats.NEW_LINE + Formats.DOUBLE_SPACE + String.format(Formats.MISSION,
                this.getCodeName(), this.getState());
    }
}
