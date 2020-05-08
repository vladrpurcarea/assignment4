package svg.shape.path;

public class Close extends PathOp {

    public Close() {
        super('z');
    }

    @Override
    public void load(String expr) {
        // .
    }

    @Override
    public String format() {
        return "[Z]*";
    }
}
