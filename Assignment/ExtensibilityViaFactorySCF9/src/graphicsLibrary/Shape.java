package graphicsLibrary;

import java.util.*;

public interface Shape {

	public double getArea();

	public double getPerimeter();

	public Point getOrigin();

	public boolean isPointEnclosed(Point point);

	double getOriginDistance();

	public Date getTimestamp();

	public ShapeType getShapeType();
}

enum ShapeType {

	RECTANGLE, TRIANGLE, SQUARE, CIRCLE, REGULAR_POLYGON;
}
