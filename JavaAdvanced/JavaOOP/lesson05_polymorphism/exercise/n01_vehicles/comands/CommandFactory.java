package lesson05_polymorphism.exercise.n01_vehicles.comands;

import java.util.function.Function;

public enum CommandFactory {
    Drive(DriveWithAcCommand::new),
    Refuel(RefuelCommand::new)
    ;

    private final Function<Double, Command> aNew;

    CommandFactory(Function<Double, Command> aNew) {
        this.aNew = aNew;
    }

    public static Command construct(String type, Double argument) {
        return CommandFactory.valueOf(type).aNew.apply(argument);
    }
}
