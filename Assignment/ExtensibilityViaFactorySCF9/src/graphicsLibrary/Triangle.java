package graphicsLibrary;

import java.util.Date;


public class Triangle implements Shape {

	public Date timestamp = null; //time at which object is added to screen
	public double firstSide, secondSide, thirdSide;
	public double height;
	public Point origin;

	public Triangle (double firstSide, double secondSide, double thirdSide, double height, Date timestamp, Point origin) {
		this.firstSide = firstSide; 
		this.secondSide = secondSide; 
		this.thirdSide = thirdSide;
		this.height = height;
		this.origin = origin;
		this.timestamp = timestamp;
	}


	@Override
	public double getArea() {
		double p = getPerimeter();
		return Math.sqrt(p*(p - firstSide)*(p - secondSide)*(p - thirdSide));
	}

	@Override
	public double getPerimeter() {
		return (firstSide + secondSide + thirdSide);
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		boolean enclosed = false;
		double base = Math.sqrt(Math.pow(thirdSide, 2) - Math.pow(height, 2));
		Point b = new Point(origin.getxPoint() + firstSide, origin.getyPoint());
		Point c = new Point(origin.getxPoint() + base, origin.getyPoint() + height);

		if(Math.abs(getArea() - ((getAreaByVertices(point, origin, b)) 
				+ getAreaByVertices(point, b, c) + getAreaByVertices(point, origin, c))) <= 0.001)
			enclosed = true;        

		return enclosed;
	}

	@Override
	public Date getTimestamp() {
		return timestamp;
	}


	@Override
	public ShapeType getShapeType() {
		return ShapeType.TRIANGLE;
	}

	@Override
	public double getOriginDistance() {		
		return Math.sqrt((origin.getxPoint() - 0) * (origin.getxPoint() - 0) 
				+ (origin.getyPoint() - 0) * (origin.getyPoint() - 0));
	}

	public double getAreaByVertices(Point a, Point b, Point c)
	{
		return Math.abs((a.getxPoint() * (b.getyPoint() - c.getyPoint()) 
				+ b.getxPoint() * (c.getyPoint() - a.getyPoint()) 
				+ c.getxPoint() * (a.getyPoint() - b.getyPoint())) / 2.0);
	} 
}
