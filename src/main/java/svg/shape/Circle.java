package svg.shape;

public class Circle extends Shape {

    private double cx;
    private double cy;
    private double r;

    public Circle() {
        super("circle");
    }

    public Circle newInstance() {
        return new Circle();
    }

}
