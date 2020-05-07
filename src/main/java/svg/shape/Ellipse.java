package svg.shape;

public class Ellipse extends Shape {

    private double cx;
    private double cy;
    private double rx;
    private double ry;

    public Ellipse() {
        super("ellipse");
    }

    public Ellipse newInstance() {
        return new Ellipse();
    }
}
