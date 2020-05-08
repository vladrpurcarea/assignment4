package svg.shape.path;

import svg.shape.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Path extends Shape {

    private List<PathOp> pathOps;

    public Path() {
        super("path");
    }

    public Path newInstance() {
        return new Path();
    }

    public boolean load(final String expr) throws IllegalAccessException{
        pathOps = new ArrayList<>();

        Matcher matcher = Pattern.compile("d\\s*=\\s*\"(.+?)\"").matcher(expr);
        if (!matcher.find() || matcher.groupCount() != 1) {
            return false;
        }
        String[] pathOpExprs = matcher.group(1).split("(?=[MQZLC])");
        for (var pathOpExpr : pathOpExprs) {
            PathOp op = PathOpMapper.mapLabelToPathOp(pathOpExpr);
            op.load(pathOpExpr);
            pathOps.add(op);
        }

        return true;
    }

    public String format() throws IllegalAccessException {
        String str = label() + ": ";
        for (PathOp op : pathOps) {
            str += op.format() + " ";
        }
        return str + "\n";
    }

}
