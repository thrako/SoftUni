package lesson05_polymorphism.exercise.n04_word;

public class Initialization {

    public static CommandInterface buildCommandInterface(StringBuilder text) {
        CommandImpl commandInterfaceInstance = new CommandImpl(text);
        commandInterfaceInstance.init();
        return commandInterfaceInstance;
    }
}
