package svg.shape.polyline;

import svg.shape.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polyline extends Shape {

    List<Point2D> points;
    Pattern regex;

    public Polyline(String label) {
        super(label);
        points = new ArrayList<>();
        regex = Pattern.compile("points\\s*=\\s*\"(.*?)\"");
    }

    public Polyline() {
        this("polyline");
    }

    public Polyline newInstance() {
        return new Polyline();
    }

    public boolean load(final String expr) {
        this.expr = expr;
        Matcher matcher = regex.matcher(expr);
        if (!matcher.find() || matcher.groupCount() != 1) {
            return false;
        }
        String[] pointStrings = matcher.group(1).split("\\s+");
        for (int i = 0; i < pointStrings.length - 1; i+=2) {
            points.add(new Point2D(Double.valueOf(pointStrings[i]), Double.valueOf(pointStrings[i+1])));
        }
        return true;
    }


    @Override
    public String format() {
        String str = label() + ":";
        for (Point2D point : points) {
            str += String.format(" (%f, %f)", point.x, point.y);
        }
        return str + "\n";
    }

    private class Point2D {
        double x;
        double y;

        Point2D(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
