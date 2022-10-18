public class Triangle implements GeometricObject {
    private Point p1;
    private Point p2;
    private Point p3;

    Triangle(Point p1, Point p2, Point p3) throws RuntimeException {
        if (p1.equals(p2) || p2.equals(p3) || p3.equals(p1)) {
            throw new RuntimeException("3 points are identical");
        } else if ((p3.getPointX() - p1.getPointX()) / (p2.getPointX() - p1.getPointX())
                == (p3.getPointY() - p1.getPointY()) / (p2.getPointY() - p1.getPointY())) {
            throw new RuntimeException("3 points aligns");
        } else {
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;

        }
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    /**
     * Calculate the area of the triangle.
     * @return the triangle's area
     */
    public double getArea() {
        return Math.abs(p1.getPointX() * (p2.getPointY() - p3.getPointY())
                + p2.getPointX() * (p3.getPointY() - p1.getPointY())
                + p3.getPointX() * (p1.getPointY() - p2.getPointY())) / 2.0;
    }

    /**
     * Calculate the perimeter of the triangle.
     * @return the triangle's perimeter
     */
    public double getPerimeter() {
        return p1.distance(p2) + p2.distance(p3) + p3.distance(p1);
    }

    /**
     * Get info of the triangle.
     * @return info of the triangle
     */
    public String getInfo() {
        return "Triangle[("
                + String.format("%.2f", p1.getPointX()) + ","
                + String.format("%.2f", p1.getPointY()) + "),("
                + String.format("%.2f", p2.getPointX()) + ","
                + String.format("%.2f", p2.getPointY()) + "),("
                + String.format("%.2f", p3.getPointX()) + ","
                + String.format("%.2f", p3.getPointY()) + ")]";
    }
}
