package svg.shape.path;

import svg.shape.Shape;

import java.util.List;

public class Path extends Shape {

    private List<PathOp> pathOps;

    public Path() {
        super("path");
    }

    public Path newInstance() {
        return new Path();
    }
}
