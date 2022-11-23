package lesson05_polymorphism.lab.n01_math_operation;

public class MathOperation {

    public int add(int n1, int n2) {
        return n1 + n2;
    }

    public int add(int n1, int n2, int n3) {
        return add(add(n1, n2), n3);
    }

    public int add(int n1, int n2, int n3, int n4) {
        return add(add(n1, n2), add(n3, n4));
    }

}
