package simulation;

/**
 * <b>WORK IN PROGRESS</b>
 * Handles some basic functionality which would be possible in a 2D array.<br>
 * TODO add an <code>int</code> verison which <i>extends</i> this class, overriding the private thing?<br>
 * Think things like super.function(input.parseInt);
 * @author South Salem High School
 *
 */
public class RectangleGrid {
	//2D arrays are more professional looking, no?
	private String[][] grid;
	
	/**
	 * @return the grid
	 */
	public String[][] getGrid() {
		return grid;
	}

	/**
	 * @param grid the grid to set
	 */
	public void setGrid(String[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Gets the "width" of the grid (Outermost of the nest)
	 * @return The "width" (Outermost nest)
	 */
	public int getWidth()
	{
		return grid.length;
	}
	
	/**
	 * Gets the "height" of the grid, based on the first array contained.<br>
	 * Yeah, rough arrays are not my problem right now.
	 * @return
	 */
	public int getHeight()
	{
		return grid[0].length;
	}
	
	/**
	 * Creates a RectangleGrid out of a two-dimensional string array.<br>
	 * This function will need to be used if you want a "rough" array, although note that such are not entirely supported by this class.
	 * @param initialGrid The grid to create a RectangleGrid out of.
	 */
	public RectangleGrid(String[][] initialGrid)
	{
		setGrid(initialGrid.clone());
	}
	
	/**
	 * Creates a RectangleGrid out of a predetermined size.
	 * @param width The width of the grid
	 * @param height The height of the grid
	 */
	public RectangleGrid(int width, int height)
	{
		setGrid(new String[width][height]);
	}
	
	/**
	 * Creates a RectangleGrid out of a predetermined size.
	 * @param size The size of the grid
	 */
	public RectangleGrid(int size)
	{
		setGrid(new String[size][size]);
	}
	
	/**
	 * Creates a RectangleGrid of size 0.<br>
	 * plzno. :(
	 */
	public RectangleGrid()
	{
		setGrid(new String[0][0]);
	}
	
	/*
	 * Basic manipulation
	 */
	public void addRow()//Untested
	{
		String[][] dummy = new String[getWidth()][getHeight()+1];
		for(int i=0;i<getWidth();i++)
		{
			for(int j=0;j<getHeight();j++)
			{
				dummy[i][j]=grid[i][j];
			}
			dummy[i][getHeight()]="";
		}
	}
	
	public void addColumn()//Untested
	{
		String[][] dummy = new String[getWidth()+1][getHeight()];
		for(int i=0;i<getWidth();i++)
		{
			for(int j=0;j<getHeight();j++)
			{
				dummy[i+1][j]=grid[i][j];
			}
			dummy[i][getHeight()]="";
		}
	}
	
	public void expandToSquare()//Untested
	{
		//TODO
		System.out.println("this funciton isn't done yet");
	}
}
