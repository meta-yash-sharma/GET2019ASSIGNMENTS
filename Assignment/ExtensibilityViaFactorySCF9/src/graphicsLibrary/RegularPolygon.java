package graphicsLibrary;

import java.util.*;


public class RegularPolygon implements Shape {

	public double noOfSides;
	public double lengthOfSide;
	public Date timestamp;
	public Point origin;

	public RegularPolygon(double noOfSides, double lengthOfSide, Date timestamp, Point origin) {
		this.noOfSides = (int)noOfSides;
		this.lengthOfSide = lengthOfSide;
		this.origin = origin;
		this.timestamp = timestamp;
	}

	@Override
	public double getArea()
	{
		double apothem = lengthOfSide / (2 * Math.tan(Math.toRadians(180 / noOfSides)));        
		return (getPerimeter() * apothem / 2);
	}

	@Override
	public double getPerimeter()
	{
		return noOfSides * lengthOfSide;
	}

	@Override
	public Point getOrigin()
	{
		return origin;
	}

	@Override
	public boolean isPointEnclosed(Point givenPoint)
	{
		return false;
	}


	@Override
	public double getOriginDistance()
	{
		return Math.sqrt((origin.getxPoint() - 0) * (origin.getxPoint() - 0) 
				+ (origin.getyPoint() - 0) * (origin.getyPoint() - 0));

	}

	@Override
	public Date getTimestamp() {
		return null;
	}


	@Override
	public ShapeType getShapeType() {
		return ShapeType.REGULAR_POLYGON;
	}

}