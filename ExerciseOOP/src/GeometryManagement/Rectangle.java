<<<<<<< Updated upstream:GeometryManager/src/Rectangle.java
public class Rectangle extends Geometry{
    private double length,width;

    public Rectangle() {
    }
=======
package GeometryManagement;

public class Rectangle extends Geometry {
    private double length;
    private double width;
>>>>>>> Stashed changes:ExerciseOOP/src/GeometryManagement/Rectangle.java

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    double calculateArea() {
        return this.length*this.width;
    }

    @Override
    double calculatePerimeter() {
        return 2*(this.length+this.width);
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
