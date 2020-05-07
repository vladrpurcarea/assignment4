package svg.shape;

import svg.Element;

import java.lang.reflect.InvocationTargetException;

public class ShapeMapper {

    private static Class[] shapeClasses = {Circle.class, Ellipse.class, Line.class, Rect.class};

    public static Element mapLabelToElement(String label) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        for (Class cls : shapeClasses) {
            Element element = (Element) cls.getDeclaredConstructor().newInstance();
            if (element.label().equalsIgnoreCase(label)) {
                return element;
            }
        }
        return null;
    }

}
