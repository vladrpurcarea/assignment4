package svg.text;

import svg.BaseElement;
import svg.Element;

/**
 * SVG text elements. How handled yet -- added for completeness.
 * @author cambolbro
 */
public class Text extends BaseElement
{

	public Text()
	{
		super("Text");
	}

	public Element newInstance()
	{
		return new Text();
	}

	public boolean load(final String expr)
	{
		try
		{
			throw new Exception("SVG text loading not implemented yet.");
		} 
		catch (Exception e)
		{
		}
		return false;
	}

}
