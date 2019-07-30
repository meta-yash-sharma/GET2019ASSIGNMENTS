package graphicsLibrary;

import java.util.Date;


public class Circle implements Shape {

	public Date timestamp = null; //time at which object is added to screen
	public double radius;
	public Point origin;
	private final double PI = 3.14d;

	/**
	 * Circle Class Constructor
	 * @param radius		An Double positive value , Denoting the Radius of Circle.
	 * @param timestamp		An Date type object, A timestamp is created when object is created. 
	 * @param origin		An Point type object, The (x,y) coordinates of the origin point.
	 */
	public Circle(double radius, Date timestamp, Point origin) {
		this.radius = radius;
		this.origin = origin;
		this.timestamp = timestamp;
	}


	/**
	 * @return	An double variable, which is equal to the area of Circle.
	 */
	@Override
	public double getArea() {
		return PI*(radius*radius);
	}


	/**
	 * @return	An double variable, which is equal to the perimeter of Circle.
	 */
	@Override
	public double getPerimeter() {
		return 2*PI*radius;
	}


	/**
	 * @return the origin point of circle.
	 */
	@Override
	public Point getOrigin() {
		return origin;
	}


	/**
	 * @param	An point class object.
	 * @return	True if the point is enclosed in the Circle.
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		boolean isInCircle = false;

		double distance = Math.sqrt(Math.pow(point.getxPoint()- origin.getxPoint(), 2) 
				+ Math.pow(point.getyPoint()- origin.getyPoint(), 2) );

		if(distance < radius)
			isInCircle = true;		
		return isInCircle;
	}


	/**
	 * @return	An Date class object, the timestamp of when the object is created.  
	 */
	@Override
	public Date getTimestamp() {
		return timestamp;
	}


	@Override
	public ShapeType getShapeType() {
		return ShapeType.CIRCLE;
	}


	public double getOriginDistance() {

		return Math.sqrt((origin.getxPoint() - 0) * (origin.getxPoint() - 0) 
				+ (origin.getyPoint() - 0) * (origin.getyPoint() - 0));
	}

	/**
	 * 
	 * @return		An point class OBJECT, Tells the center point of circle.
	 */
	public Point getCenterCoordinates() {
		double xAxis, yAxis;
		double theta = Math.atan(origin.getyPoint() / origin.getxPoint());

		xAxis = radius * Math.sin(theta);
		yAxis = radius * Math.cos(theta);

		return new Point(origin.getxPoint() + xAxis, origin.getyPoint() + yAxis);   	
	}

}
