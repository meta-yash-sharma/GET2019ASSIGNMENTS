package graphicsLibrary;

import java.util.Date;

public class Square implements Shape {

	public Date timestamp = null; //time at which object is added to screen
	public double sideOfSquare;
	public Point origin;

	public Square(double sideOfSquare, Date timestamp, Point origin) {
		this.sideOfSquare = sideOfSquare;
		this.origin = origin;
		this.timestamp = timestamp;
	}

	@Override
	public double getArea() {
		return (sideOfSquare*sideOfSquare);
	}

	@Override
	public double getPerimeter() {
		return 4*sideOfSquare;
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		boolean isEnclosed = false;

		if(point.getxPoint() >= origin.getxPoint() 
				&& point.getxPoint() <= sideOfSquare && point.getyPoint() >= origin.getyPoint() 
				&& point.getyPoint() <= sideOfSquare)
			isEnclosed = true;

		return isEnclosed;
	}

	@Override
	public Date getTimestamp() {
		return timestamp;
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.SQUARE;
	}

	@Override
	public double getOriginDistance() {
		return Math.sqrt((origin.getxPoint() - 0) * (origin.getxPoint() - 0) 
				+ (origin.getyPoint() - 0) * (origin.getyPoint() - 0));
	}

}
