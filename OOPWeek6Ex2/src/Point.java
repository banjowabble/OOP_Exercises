import java.util.Objects;

public class Point {
    private double pointX;
    private double pointY;

    public Point(double pointX, double pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public double getPointX() {
        return pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    public double distance(Point other) {
        return Math.sqrt(Math.pow(pointX - other.getPointX(), 2)
                + Math.pow(pointY - other.getPointY(), 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return Math.abs(point.pointX - pointX) <= 0.001 && Math.abs(point.pointY - pointY) <= 0.001;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointX, pointY);
    }

    @Override
    public String toString() {
        double roundedPointX = Math.round(pointX * 10.0) / 10.0;
        double roundedPointY = Math.round(pointY * 10.0) / 10.0;
        return "(" + roundedPointX + "," + roundedPointY + ")";
    }
}
