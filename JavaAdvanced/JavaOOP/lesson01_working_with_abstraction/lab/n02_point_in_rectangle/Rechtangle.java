package lesson01_working_with_abstraction.lab.n02_point_in_rectangle;

public class Rechtangle {

    Point bottomLeft;
    Point topRight;

    public Rechtangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point) {
        return point.getX() >= bottomLeft.getX()
               && point.getX() <= topRight.getX()
               && point.getY() >= bottomLeft.getY()
               && point.getY() <= topRight.getY();
    }
}
