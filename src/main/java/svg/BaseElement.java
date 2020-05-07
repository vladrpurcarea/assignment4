package svg;

/**
 * Base SVG element type.
 * @author cambolbro
 */
public abstract class BaseElement implements Element
{
	private final String label;

	// Character position in SVG file
	private int filePos;

	public BaseElement(final String label)
	{
		this.label = label;
	}

	public String label()
	{
		return label;
	}

	public int compare(final Element other)
	{
		return filePos - ((BaseElement)other).filePos;
	}

	public int filePos()
	{
		return filePos;
	}
	
	public void setFilePos(final int pos)
	{
		filePos = pos;
	}

}
