abstract class Shape {
    protected String color;
    protected boolean filled;

    public Shape() {
        color = null;
        filled = false;
    }

    Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    //Calculate the shape's perimeter
    public abstract double getPerimeter();

    //Draw the shape in form of a message
    public String draw() {
        return "Shape[color=" + color + ",filled=" + filled + "]";
    }
}
