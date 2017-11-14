package userInterface;
/**
 * A point class pairs corresponding x and y coordinates 
 * @author Shardul
 */
public class Point {

	private int x;
	private int y;
	/**
     * Instantiates a point class with x and y values 
     * @param _x
     * @param _y 
     */
	public Point(int _x, int _y)
	{
		this.x = _x;
		this.y = _y;
	}
	/**
     * Getter for x
     * @return x
     */
	public int getX()
	{
		return this.x;
	}
	/**
     * Getter for y
     * @return y
     */
	public int getY()
	{
		return this.y;
	}
}
