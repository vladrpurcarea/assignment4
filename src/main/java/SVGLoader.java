import svg.Element;
import svg.SVG;
import svg.shape.ShapeMapper;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SVGLoader {
	public static void main(String args[]) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		if (args.length != 1) {
			System.out.println("First command line arg should be path to svg file");
		}
		String filename = args[0];
		String content = Files.readString(Paths.get(filename), StandardCharsets.UTF_8);

		Pattern pattern = Pattern.compile("<(.+?)>");
		Matcher matcher = pattern.matcher(content);

		SVG svg = new SVG();
		while (matcher.find()) {
			String line = matcher.group(1).toLowerCase();
			String label = line.split("\\s+")[0];
			Element element = ShapeMapper.mapLabelToElement(label);
			if (element == null) {
				continue;
			}
			element.load(line);
			svg.elements().add(element);
		}
		System.out.println(Arrays.toString(svg.elements().toArray()));
	}
}
