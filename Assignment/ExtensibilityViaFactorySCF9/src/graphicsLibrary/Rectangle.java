package graphicsLibrary;

import java.util.*;

public class Rectangle implements Shape {

	public Date timestamp = null; //time at which object is added to screen
	public double length, breadth;
	public Point origin;

	public Rectangle(double length, double breadth, Date timestamp, Point origin) {
		this.length = length;
		this.breadth = breadth;
		this.origin = origin;
		this.timestamp = timestamp;
	}


	@Override
	public double getArea() {
		return length * breadth;
	}

	@Override
	public double getPerimeter() {
		return 2*(length + breadth);
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public boolean isPointEnclosed(Point point) {

		boolean isEnclosed = false;

		if(point.getxPoint() >= origin.getxPoint() 
				&& point.getxPoint() <= length && point.getyPoint() >= origin.getyPoint() 
				&& point.getyPoint() <= breadth)
			isEnclosed = true;

		return isEnclosed;
	}

	@Override
	public Date getTimestamp() {
		return timestamp;
	}


	@Override
	public ShapeType getShapeType() {
		return ShapeType.RECTANGLE;
	}


	@Override
	public double getOriginDistance() {

		return Math.sqrt((origin.getxPoint() - 0) * (origin.getxPoint() - 0) 
				+ (origin.getyPoint() - 0) * (origin.getyPoint() - 0));
	}
}
