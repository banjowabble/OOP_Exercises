import java.util.ArrayList;
import java.util.List;

public class ClientTest {
    public static void main(String[] args) {
        System.out.println("Test circle");
        Point center = new Point(50,50);
        Circle c1 = new Circle(center,5.5);
        System.out.println(c1.getInfo());
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());

        System.out.println("\nTest triangle");
        Point p1 = new Point(0,0);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(3, 4);
        Triangle t1 = new Triangle(p1, p2, p3);
        System.out.println(t1.getInfo());
        System.out.println(t1.getArea());
        System.out.println(t1.getPerimeter());

        System.out.println("\nTest printInfo");
        List<GeometricObject> shapes = new ArrayList<>();
        shapes.add(c1);
        shapes.add(t1);
        System.out.println(ShapeUtil.printInfo(shapes));
    }
}
