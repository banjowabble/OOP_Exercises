import java.util.Objects;

public class Rectangle extends Shape {
    protected Point topLeft;
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

    /**
     * create a rectangle.
     * @param width width
     * @param length length
     * @param color color
     * @param filled filled
     */
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    /**
     * create a rectangle.
     * @param topLeft topLeft
     * @param width width
     * @param length length
     * @param color color
     * @param filled filled
     */
    public Rectangle(Point topLeft, double width, double length, String color, boolean filled) {
        super(color, filled);
        this.topLeft = topLeft;
        this.width = width;
        this.length = length;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
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

    public double getArea() {
        return width * length;
    }

    public double getPerimeter() {
        return (width + length) * 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Rectangle rectangle = (Rectangle) o;
        return Math.abs(rectangle.width - width) <= 0.001
                && Math.abs(rectangle.length - length) <= 0.001
                && topLeft.equals(rectangle.topLeft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, width, length);
    }

    @Override
    public String toString() {
        double roundedWidth = Math.round(width * 10.0) / 10.0;
        double roundedLength = Math.round(length * 10.0) / 10.0;
        return "Rectangle["
                + "topLeft=" + topLeft
                + ",width=" + roundedWidth
                + ",length=" + roundedLength
                + ",color=" + color
                + ",filled=" + filled + "]";
    }
}
