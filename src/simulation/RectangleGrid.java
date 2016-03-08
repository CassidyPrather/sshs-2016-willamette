package simulation;

import java.util.Arrays;

/**
 * Handles some basic functionality which would be possible in a 2D array.<br>
 * Note that this is <b>not</b> the same thing mentioned in the issue tracker; This class was being worked on before the issue was created<br>
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
	
	public void addRow(int index)
	{
		if(index>getHeight())
		{
			index = getHeight();//Is this proper? Am I allowed to mess with the parameters directly?
		}
		String[][] dummy = new String[getWidth()][getHeight()+1];
		for(int i=0;i<getWidth();i++)
		{
			for(int j=0;j<index;j++)
			{
				dummy[i][j]=grid[i][j];
			}
			dummy[i][index]="";
			for(int k=index;k<getHeight();k++)
			{
				dummy[i][k+1]=grid[i][k];
			}
		}
	}
	
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
	
	public void addRows(int amount)
	{
		if(amount<0)
		{
			return;//Is this proper?
		}
		for(int i=0;i<amount;i++)
		{
			addRow();
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
	
	
	public void addColumns(int amount)
	{
		if(amount<0)
		{
			return;//Is this proper?
		}
		for(int i=0;i<amount;i++)
		{
			addColumn();
		}
	}
	
	public void expandToSquare()//Untested
	{
		if(getWidth()>getHeight())
		{
			addRows(getWidth()-getHeight());
		}
		else if(getWidth()<getHeight())
		{
			addColumns(getHeight()-getWidth());
		}
	}
	
	public void deleteRow()
	{
		
	}

	@Override
	public String toString() {
		String formatted = "";
		for(int i=0;i<getHeight();i++)
		{
			for(int k=0;k<getWidth();k++)
			{
				formatted+=grid[k][i]+" ";
			}
			formatted+="\n";
		}
		return "RectangleGrid: ";
	}
	
	
}
