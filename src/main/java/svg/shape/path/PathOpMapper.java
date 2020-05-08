package svg.shape.path;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class PathOpMapper {

    static final Class[] pathOpClasses = {CubicTo.class, QuadTo.class, LineTo.class, MoveTo.class, Close.class};

    public static PathOp mapLabelToPathOp(String expr) {
        for (Class cls : pathOpClasses) {
            try {
                PathOp op = (PathOp) cls.getDeclaredConstructor().newInstance();
                if (expr.toLowerCase().charAt(0) == op.label) {
                    return op;
                }
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        }
        return null;
    }

}
