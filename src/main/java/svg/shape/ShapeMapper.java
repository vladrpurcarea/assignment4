package svg.shape;

import svg.Element;
import svg.shape.path.Path;
import svg.shape.polyline.Polygon;
import svg.shape.polyline.Polyline;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ShapeMapper {

    private final static Class[] shapeClasses = {
            Circle.class, Ellipse.class, Line.class, Rect.class,
            Polygon.class, Polyline.class, Path.class
    };

    public static Element mapLabelToElement(String label) {
        for (Class cls : shapeClasses) {
            try {
                Element element = (Element) cls.getDeclaredConstructor().newInstance();
                if (element.label().equalsIgnoreCase(label)) {
                    return element;
                }
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        }
        return null;
    }

}
