import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(2);
        Rectangle rectangle = new Rectangle(4, 2);

        System.out.println(rectangle.toString());

        System.out.println("Area of rectangle:" + rectangle.calculateArea());
        System.out.println("Perimeter of rectangle:" + rectangle.calculatePerimeter());
        System.out.println("Geometry name:" + rectangle.getShapeName());

        ArrayList<Geometry> list = new ArrayList<>();
        list.add(circle);
        list.add(rectangle);

        System.out.println("-------ArrayList--------");

        for (Geometry geometry : list) {
            if (geometry instanceof Circle toCircle) {
                System.out.println(toCircle.toString());
            } else {
                Rectangle toRectangle = (Rectangle) geometry;
                System.out.println("Area of rectangle:" + toRectangle.calculateArea());
                System.out.println("Perimeter of rectangle:" + toRectangle.calculatePerimeter());
                System.out.println("Geometry name:" + toRectangle.getShapeName());
            }
        }
    }
}
