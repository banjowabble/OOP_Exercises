public class Square extends Rectangle {
    public Square() {
        super();
    }

    public Square(double side) {
        this.width = side;
        this.length = side;
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return width;
    }

    public void setSide(double side) {
        width = side;
        length = side;
    }

    @Override
    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setLength(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    //Draw the square in form of a message
    @Override
    public String draw() {
        return "Square["
                + "side=" + width
                + ",color=" + color
                + ",filled=" + filled + "]";
    }
}
