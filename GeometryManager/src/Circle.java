public class Circle extends Geometry{
    private double radius;
    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI*this.radius*this.radius;
    }

    @Override
    double calculatePerimeter() {
        return 2*Math.PI*this.radius;
    }



    @Override
    String getShapeName() {
        return "Circle";
    }
}
