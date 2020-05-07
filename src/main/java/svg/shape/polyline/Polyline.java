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
    }

    public Polyline() {
        super("polyline");
        points = new ArrayList<>();
        regex = Pattern.compile("points\\s*=\\s*\"(.*?)\"");
    }

    public Polyline newInstance() {
        return new Polyline();
    }

    public boolean load(final String expr) {
        Matcher matcher = regex.matcher(expr);
        if (!matcher.find() || matcher.groupCount() != 1) {
            return false;
        }
        for (String point : matcher.group(1).split("\\s+")) {
            String[] pointSplit = point.split(",");
            if (pointSplit.length != 2) {
                return false;
            }
            points.add(new Point2D(Double.valueOf(pointSplit[0]), Double.valueOf(pointSplit[1])));
        }
        return true;
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
