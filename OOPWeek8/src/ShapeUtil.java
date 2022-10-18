import java.util.List;

public class ShapeUtil {
    /**
     * Print information of a list of shapes.
     * @param shapes list of shapes
     * @return info of each shape in the list
     */
    public static String printInfo(List<GeometricObject> shapes) {
        String result = "Circle:\n";
        for (GeometricObject shape : shapes) {
            if (shape instanceof Circle) {
                result = result.concat(shape.getInfo() + "\n");
            }
        }
        result = result.concat("Triangle:\n");
        for (GeometricObject shape : shapes) {
            if (shape instanceof Triangle) {
                result = result.concat(shape.getInfo() + "\n");
            }
        }
        return result;
    }
}
