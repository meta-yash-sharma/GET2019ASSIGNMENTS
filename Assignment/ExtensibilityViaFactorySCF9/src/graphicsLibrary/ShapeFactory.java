package graphicsLibrary;

import java.util.*;

public class ShapeFactory {

	public static Shape createShape(ShapeType shapeType, Point origin, List<Double> parameters) {
		Shape shapeObject = null;
		Date timestamp = new Date();
		switch(shapeType)
		{		
		case CIRCLE:
			shapeObject = new Circle(parameters.get(0), timestamp, origin);
			break; 

		case RECTANGLE:
			shapeObject = new Rectangle(parameters.get(0), parameters.get(1), timestamp, origin);
			break;

		case SQUARE:
			shapeObject = new Square(parameters.get(0), timestamp, origin);
			break;

		case TRIANGLE:
			shapeObject = new Triangle(parameters.get(0), parameters.get(1), parameters.get(2),  parameters.get(3), timestamp , origin);
			break;

		case REGULAR_POLYGON:
			shapeObject = new RegularPolygon(parameters.get(0),  parameters.get(1),  timestamp, origin);
			break;

		}
		return shapeObject;
	}

}
