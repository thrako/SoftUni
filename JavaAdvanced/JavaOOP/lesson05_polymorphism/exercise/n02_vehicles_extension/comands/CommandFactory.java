package lesson05_polymorphism.exercise.n02_vehicles_extension.comands;

import java.util.function.Function;

public enum CommandFactory {
    Drive(DriveWithAcCommand::new),
    DriveEmpty(DriveWithoutAcCommand::new),
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
