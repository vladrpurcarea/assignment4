package svg.shape.path;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public abstract class PathOp {

    protected char label;
    protected boolean absolute;
    private List<Field> coordField;

    public PathOp(char label) {
        this.label = label;
        coordField = new ArrayList<>(Arrays.asList(this.getClass().getDeclaredFields()));
        coordField.removeIf(f -> !f.getName().matches("[xy]\\d*$"));
        coordField.sort(Comparator.comparingInt(this::convertField));
    }

    private int convertField(Field f) {
        return Integer.valueOf(new StringBuilder(f.getName()
                .replace("x", "1")
                .replace("y", "2"))
                .reverse().toString());
    }

    public void load(String expr) throws IllegalAccessException {
        load(expr, -1);
    }

    public void load(String expr, int level) throws IllegalAccessException {
        if (level == -1) {
            absolute = expr.charAt(0) >= 'A' && expr.charAt(0) <='Z';
            load(expr.substring(1), ++level);
            return;
        }

        Field field = coordField.get(level);
        String[] next = expr.split("[,\\s]+");
        field.setAccessible(true);
        field.set(this, Double.valueOf(next[0]));

        if (next.length == 1) {
            return;
        }
        load(expr.substring(next[0].length()+1), ++level);
    }

    public String format() throws IllegalAccessException {
        String str = "[" + String.valueOf((char) (label - 'a' + 'A')) + ":";
        for (Field field : coordField) {
            field.setAccessible(true);
            str += String.format(" %s=%f", field.getName(), (Double) field.get(this));
        }
        return str + "]" + (absolute ? "*" : "");
    }

}
