package GeometryManagement;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Circle c= new Circle(2);
        Rectangle r= new Rectangle(4,2);

<<<<<<< Updated upstream:GeometryManager/src/Main.java
        System.out.println("Area of circle:"+ c.calculateArea());
        System.out.println("Perimeter of circle:"+ c.calculatePerimeter());
        System.out.println("Geometry name:"+  c.getShapeName());
=======
        System.out.println(circle.toString());
        System.out.println(rectangle.toString());

        ArrayList<Geometry> list = new ArrayList<>();
        list.add(circle);
        list.add(rectangle);
>>>>>>> Stashed changes:ExerciseOOP/src/GeometryManagement/Main.java

        System.out.println("Area of rectangle:"+ r.calculateArea());
        System.out.println("Perimeter of rectangle:"+ r.calculatePerimeter());
        System.out.println("Geometry name:"+  r.getShapeName());
        ArrayList<Geometry> list= new ArrayList<>();
        list.add(c);
        list.add(r);
        System.out.println("-------ArrayList--------");
<<<<<<< Updated upstream:GeometryManager/src/Main.java
        for (Geometry geometry:list) {
            if(geometry instanceof Circle){
                System.out.println("Area of circle:"+ c.calculateArea());
                System.out.println("Perimeter of circle:"+ c.calculatePerimeter());
                System.out.println("Geometry name:"+  c.getShapeName());
            }else {
                System.out.println("Area of rectangle:"+ r.calculateArea());
                System.out.println("Perimeter of rectangle:"+ r.calculatePerimeter());
                System.out.println("Geometry name:"+  r.getShapeName());
=======

        for (Geometry geometry : list) {
            if (geometry instanceof Circle toCircle) {
                System.out.println(toCircle.toString());
            } else {
                Rectangle toRectangle = (Rectangle) geometry;
                System.out.println(toRectangle.toString());
>>>>>>> Stashed changes:ExerciseOOP/src/GeometryManagement/Main.java
            }
        }
    }
}
