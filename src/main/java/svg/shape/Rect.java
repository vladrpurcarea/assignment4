package svg.shape;

public class Rect extends Shape {

    private double x;
    private double y;
    private double rx;
    private double ry;
    private double width;
    private double height;

    public Rect() {
        super("rect");
    }

    public Rect newInstance() {
        return new Rect();
    }
}
