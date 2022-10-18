public class ClientTest {
    public static void main(String[] args) {

        System.out.println("Test circle");
        Point center = new Point(50,50);
        Circle c1 = new Circle(center,5.5, "RED", false);
        System.out.println(c1);
        System.out.println(c1.getCenter());

        System.out.println("Test rectangle");
        Point topLeft = new Point(0,0);
        Rectangle r1 = new Rectangle(topLeft, 1.0, 2.0, "RED", false);
        System.out.println(r1);
        System.out.println(r1.getTopLeft());

        System.out.println("Test square");
        Square sq1 = new Square(topLeft, 6.6, "YELLOW", false);
        System.out.println(sq1);
        System.out.println(sq1.getTopLeft());

        System.out.println("Test layer");
        Layer layer = new Layer();
        layer.addShape(c1);
        layer.addShape(r1);
        layer.addShape(sq1);
        System.out.println(layer.getInfo());

        System.out.println("Test remove circles");
        layer.removeCircles();
        System.out.println(layer.getInfo());

        System.out.println("Test remove duplicates");
        Rectangle r2 = new Rectangle(topLeft, 1.0, 2.0, "RED", false);
        layer.addShape(r2);
        System.out.println(layer.getInfo());
        layer.removeDuplicates();
        System.out.println(layer.getInfo());
    }
}