package lesson05_polymorphism.exercise.n05_calculator;

public interface Operation {
    void addOperand(int operand);
    int getResult();
    boolean isCompleted();
}
