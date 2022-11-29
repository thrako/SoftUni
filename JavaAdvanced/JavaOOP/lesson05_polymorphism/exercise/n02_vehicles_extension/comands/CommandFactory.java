package lesson05_polymorphism.exercise.n02_vehicles_extension.comands;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CommandFactory {

    private static final String UNKNOWN_COMMAND_MSG_FORMAT = "Unknown command type: %s";
    private static final Map<String, Function<Double, Command>> COMMANDS = new HashMap<>();

    static  {
        COMMANDS.put("Drive", DriveWithAcCommand::new);
        COMMANDS.put("DriveEmpty", DriveWithoutAcCommand::new);
        COMMANDS.put("Refuel", RefuelCommand::new);
    }

    public static Command construct(String type, Double argument) {
        if (!COMMANDS.containsKey(type)) {
            throw new IllegalArgumentException(String.format(UNKNOWN_COMMAND_MSG_FORMAT, type));
        }

        return COMMANDS.get(type).apply(argument);
    }
}
