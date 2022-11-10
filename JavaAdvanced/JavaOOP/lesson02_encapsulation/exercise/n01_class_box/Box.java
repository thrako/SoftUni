package lesson02_encapsulation.exercise.n01_class_box;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        if (length <= 0) throw new IllegalArgumentException("Length cannot be zero or negative.");
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) throw new IllegalArgumentException("Width cannot be zero or negative.");
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0) throw new IllegalArgumentException("Height cannot be zero or negative.");
        this.height = height;
    }

    public double calculateSurfaceArea() {
        return ((length * width) + (width * height) + (height * length)) * 2;
    }

    public double calculateLateralSurfaceArea() {
        return ((length * height) + (width * height)) * 2;
    }

    public double calculateVolume() {
        return length * width * height;
    }
}
