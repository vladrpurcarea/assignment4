package svg.shape.path;

public class CubicTo extends PathOp {

    private double x1;
    private double x2;
    private double x3;
    private double y1;
    private double y2;
    private double y3;

    public CubicTo(String expr) {
        super(expr.charAt(0));
    }

}
