public class Rectangle extends Shape {
    protected double width;
    protected double length;

    public Rectangle() {
        this.width = 0;
        this.length = 0;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    // Calculate the rectangle's perimeter
    // Calculating the square's perimeter (because square is rectangle's subclass)
    public double getPerimeter() {
        return (width + length) * 2;
    }

    //Draw the rectangle in form of a message
    @Override
    public String draw() {
        return "Rectangle["
                + "width=" + width
                + ",length=" + length
                + ",color=" + color
                + ",filled=" + filled + "]";
    }
}
