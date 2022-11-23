package lesson05_polymorphism.lab.n02_shapes;

public class Rectangle extends Shape {
    private final Double height;
    private final Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    public Double calculatePerimeter() {
        return 2 * (height + width);
    }

    @Override
    public Double calculateArea() {
        return height * width;
    }
}
