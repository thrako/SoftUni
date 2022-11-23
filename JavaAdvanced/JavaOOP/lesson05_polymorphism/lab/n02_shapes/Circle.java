package lesson05_polymorphism.lab.n02_shapes;

public class Circle extends Shape {

    private final Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() { //judge nonsense
        return radius;
    }

    @Override
    protected Double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    protected Double calculateArea() {
        return Math.PI * radius * radius;
    }
}
