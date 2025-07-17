<<<<<<< Updated upstream:GeometryManager/src/Circle.java
public class Circle extends Geometry{
=======
package GeometryManagement;

public class Circle extends Geometry {
>>>>>>> Stashed changes:ExerciseOOP/src/GeometryManagement/Circle.java
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
