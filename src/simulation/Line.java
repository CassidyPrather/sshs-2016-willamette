package simulation;

/**
 * A 2d line with basic functionality.<br>
 * @author South Salem High School
 *
 */
public class Line {
	/**
	 * The slope of the line
	 */
	private double gradient;
	
	/**
	 * The y intercept of the line
	 */
	private double yOffset;
	
	/**
	 * @return the gradient
	 */
	public double getGradient() {
		return gradient;
	}

	/**
	 * @param gradient the gradient to set
	 */
	public void setGradient(double gradient) {
		this.gradient = gradient;
	}

	/**
	 * @return the yOffset
	 */
	public double getyOffset() {
		return yOffset;
	}

	/**
	 * @param yOffset the yOffset to set
	 */
	public void setyOffset(double yOffset) {
		this.yOffset = yOffset;
	}

	/**
	 * Creates a simple line with a slope of "1" and a y intercept of 0.
	 */
	public Line()
	{
		gradient=1;
		yOffset=0;
	}
	
	/**
	 * Creates a line.
	 * @param gradient The slope of the line
	 * @param the y intercept of the line
	 */
	public Line(double gradient, double yOffset)
	{
		this.gradient=gradient;
		this.yOffset=yOffset;
	}
	/**
	 * Creates a line with the y intercept 0.
	 * @param gradient The slope of the line
	 */
	public Line(double gradient)
	{
		this.gradient=gradient;
		this.yOffset=0;
	}
	
	/*
	 * Functionality
	 */
	
	/**
	 * Reflects a point across the ray.
	 * @return An array containing the coordinates of the new line [0:x;1:y]
	 */
	public double[] reflectPoint(double x, double y)
	{
		double[] newLocation = new double[2];
		newLocation[0] = y-(x*gradient+yOffset);
		newLocation[1] = x-(y*-gradient);
	}

}
