package lesson05_polymorphism.lab.n02_shapes;

public abstract class Shape {

    private Double perimeter;
    private Double area;

    protected abstract Double calculatePerimeter();

    protected abstract Double calculateArea();

    public Double getPerimeter() {
        if (this.perimeter == null) {
            this.perimeter = calculatePerimeter();
        }
        return perimeter;
    }

    public Double getArea() {
        if (this.area == null) {
            this.area = calculateArea();
        }
        return area;
    }
}
