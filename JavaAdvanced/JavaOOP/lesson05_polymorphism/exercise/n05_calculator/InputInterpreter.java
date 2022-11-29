package lesson05_polymorphism.exercise.n05_calculator;

import java.util.Optional;

public class InputInterpreter {

    private final CalculationEngine engine;

    public InputInterpreter(CalculationEngine engine) {
        this.engine = engine;
    }

    public void interpret(String input) {
        final Optional<Integer> optionalInteger = Optional.ofNullable(isNumeric(input));
        if (optionalInteger.isPresent()) {
            engine.pushNumber(optionalInteger.get());
        } else if ("ms".equals(input)) {
            engine.memorizeResult();
        } else if ("mr".equals(input)) {
            engine.getLastMemorizedResult();
        } else {
            engine.pushOperation(this.getOperation(input));
        }
    }

    private Integer isNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception ignored) {
            return null;
        }
    }

    public Operation getOperation(String operation) {
        if (operation.equals("*")) {
            return new MultiplicationOperation();
        } else if (operation.equals("/")) {
            return new DeleteOperation();
        }
        return null;
    }
}
