package GeometryManager;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(2);
        Rectangle rectangle = new Rectangle(4, 2);

        System.out.println(circle.toString());
        System.out.println(rectangle.toString());

        ArrayList<Geometry> list = new ArrayList<>();
        list.add(circle);
        list.add(rectangle);

        System.out.println("-------ArrayList--------");

        for (Geometry geometry : list) {
            if (geometry instanceof Circle toCircle) {
                System.out.println(toCircle.toString());
            } else {
                Rectangle toRectangle = (Rectangle) geometry;
                System.out.println(toRectangle.toString());
            }
        }
    }
}
