public class Circle extends Shape {
    protected double radius;

    public Circle() {
        this.radius = 0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Calculate the circle's perimeter
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    //Draw the circle in form of a message
    @Override
    public String draw() {
        return "Circle["
                + "radius=" + radius
                + ",color=" + color
                + ",filled=" + filled
                + "]";
    }
}
