public class Circle extends Geometry {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    String getShapeName() {
        return "Circle";
    }

    @Override
    public String toString() {
        return "Area of circle:" + calculateArea() + "\n" +
                "Perimeter of circle:" + calculatePerimeter() + "\n" +
                "Geometry name:" + getShapeName();
    }
}
