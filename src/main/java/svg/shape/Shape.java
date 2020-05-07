package svg.shape;

import svg.BaseElement;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public abstract class Shape extends BaseElement {

    private Map<Field, Pattern> parser;

    public Shape(final String label) {
        super(label);
        List<Field> fields = Arrays.stream(this.getClass().getDeclaredFields()).collect(Collectors.toList());
        parser = new HashMap<>();
        fields.forEach(f -> parser.put(f, Pattern.compile(f.getName() + "\\s*=\\s*\"(\\d+)\"")));
    }

    public boolean load(final String expr) throws IllegalAccessException {
        for (Map.Entry<Field, Pattern> entry : parser.entrySet()) {
            Matcher matcher = entry.getValue().matcher(expr);
            if (!matcher.find() || matcher.groupCount() != 1) {
                return false;
            }
            entry.getKey().setAccessible(true);
            entry.getKey().set(this, Double.valueOf(matcher.group(1)));
        }
        return true;
    }

    @Override
    public String toString() {
        String str = label() + ": ";
        for (Field field : parser.keySet()) {
            field.setAccessible(true);
            try {
                str += field.getName() + "=" + String.valueOf(field.get(this)) + ", ";
            } catch (IllegalAccessException e) {
                // oopsy daisy
            }
        }
        return str + "\n";
    }
}
