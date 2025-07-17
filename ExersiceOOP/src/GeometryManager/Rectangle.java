package GeometryManager;

public class Rectangle extends Geometry {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return this.length * this.width;
    }

    @Override
    double calculatePerimeter() {
        return 2 * (this.length + this.width);
    }

    @Override
    String getShapeName() {
        return "Rectangle";
    }

    @Override
    public String toString() {
        return "Area of rectangle:" + calculateArea() + "\n" +
                "Perimeter of rectangle:" + calculatePerimeter() + "\n" +
                "Geometry name:" + getShapeName();
    }
}
