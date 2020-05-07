package svg.shape;

public class Line extends Shape {

    private double x1;
    private double y1;
    private double x2;
    private double y2;

    public Line() {
        super("line");
    }

    public Line newInstance() {
        return new Line();
    }
}
