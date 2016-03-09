package simulation;

/**
 * A 2d linear line with basic functionality.<br>
 * @author South Salem High School
 *
 */
public class BasicLine {
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
	public BasicLine()
	{
		gradient=1;
		yOffset=0;
	}
	
	/**
	 * Creates a line.
	 * @param gradient The slope of the line
	 * @param the y intercept of the line
	 */
	public BasicLine(double gradient, double yOffset)
	{
		this.gradient=gradient;
		this.yOffset=yOffset;
	}
	/**
	 * Creates a line with the y intercept 0.
	 * @param gradient The slope of the line
	 */
	public BasicLine(double gradient)
	{
		this.gradient=gradient;
		this.yOffset=0;
	}
	
	/*
	 * Functionality
	 */
	
	/**
	 * Gets the y value for a given x value
	 * @param x The x value to get the corresponding value for
	 * @return The corresponding value for the given x value
	 */
	public double getResultant(double x)
	{
		return gradient*x + yOffset;
	}
	
	/**
	 * Gets the x value of the point of interception between two lines
	 * @param other The line to check against this one
	 * @return the <b>X<b> location of the intercept
	 */
	public double getIntercept(BasicLine other)
	{
		return (other.getyOffset()-yOffset)/(gradient-other.getGradient());
	}
	
	/**
	 * Reflects a point across the ray.
	 * @return An array containing the coordinates of the new line [0:x;1:y]
	 */
	public double[] reflectPoint(double x, double y)
	{
		double[] newLocation = new double[2];
		double a = (x + (y-yOffset)*gradient)/(1+Math.pow(gradient, 2));
		newLocation[0] = (2*a)-x;
		newLocation[1] = (2*a*gradient) - y + (2*yOffset);
		return newLocation;
	}
	
	/**
	 * Gets the inverse of the slope.
	 * @return The inverted slope
	 */
	public double invertSlope()
	{
		return -1/gradient;
	}
	
	/**
	 * Returns a version of this line reflected over a verticle line at a given point.
	 * @param reflectionLocation The "X" location of the verticle line to reflect over.
	 * @return The reflected line.
	 */
	public BasicLine invertLine(double reflectionLocation)
	{
		double newGradient = invertSlope();
		return new BasicLine(newGradient,-reflectionLocation*newGradient + getResultant(reflectionLocation));
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Slope: " + gradient + ", Y Intercept: " + yOffset;
	}
	
	

}
