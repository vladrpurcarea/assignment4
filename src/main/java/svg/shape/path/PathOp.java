package svg.shape.path;

public abstract class PathOp {

    protected char label;
    protected boolean absolute;

    PathOp(char label) {
        this.label = label;
        this.absolute = (label >= 'A' && label <= 'Z');
    }

}
