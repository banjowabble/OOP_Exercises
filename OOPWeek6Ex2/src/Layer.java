import java.util.ArrayList;
import java.util.List;

public class Layer {
    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape other) {
        shapes.add(other);
    }

    /**
     * get all info about all shapes in the layer.
     * @return info
     */
    public String getInfo() {
        String result = "";

        for (Shape shape : shapes) {
            result = result.concat(shape.toString() + "\n");
        }

        return "Layer of crazy shapes:\n" + result;
    }

    /**
     * remove all circles from the layer.
     */
    public void removeCircles() {
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) instanceof Circle) {
                shapes.remove(shapes.get(i));
            }
        }
    }

    /**
     * remove all duplicates from the layer.
     */
    public void removeDuplicates() {
        List<Shape> newShapes = new ArrayList<>();

        for (Shape shape : shapes) {
            if (!newShapes.contains(shape)) {
                newShapes.add(shape);
            }
        }

        shapes = newShapes;
    }
}
