package graphicsLibrary;

import java.util.*;


public class Screen {

	public List<Shape> ShapesOnScreen = new ArrayList<Shape>();
	public double xMax, yMax;

	/**
	 *  Constructor for Screen Class
	 * @param xMax		An positive Integer value, That tell right most point of Screen.
	 * @param yMax		An positive Integer value, That tells upper most point of Screen.
	 */
	public Screen(double xMax, double yMax) {
		this.xMax = xMax;
		this.yMax = yMax;
	}


	/**
	 * Add an Object of Shape class in Screen Class
	 * @param shapeObject	An Shape class object, tell us the Shape we 
	 * want to add on screen(Triangle,Square,circle etc.)
	 * @return		True if the Shape object is added to screen class else False.
	 */
	public boolean addShape(Shape shapeObject) {
		boolean shapeAdded = false;

		if(shapeObject == null)
			throw new AssertionError("Object is null! Cannot add!");

		else {
			ShapesOnScreen.add(shapeObject);
			shapeAdded = true;    		
		}

		return shapeAdded;
	}


	/**
	 * Remove all the Shape object of a Particular type.
	 * @param type		The ShapeType objects user want to remove (i.e. Triangle,Square,circle etc.)
	 * @return			True if All the Object of Shape class with a particular shape Type removed else False.
	 */
	public boolean removeAllShapeOfType(ShapeType type) {
		if(type == null ) {
			return false;
		}

		boolean flag = false;
		for(int i = 0; i < ShapesOnScreen.size(); i++) {
			if(ShapesOnScreen.get(i).getShapeType() == type) {
				ShapesOnScreen.remove(i);
				i--;
				flag = true;
			}
		}

		try
		{
			if(!flag)
				throw new AssertionError("No object of the given type!");
		}
		catch(AssertionError error)
		{
			return false;
		}

		return flag;
	}


	/**
	 * Sort The List of Shape type object According to their Area.
	 * @return		An List of Shape type object sorted accordingly.
	 */
	public List<Shape> sortByArea()
	{

		if(ShapesOnScreen.size() == 0) {
			throw new AssertionError("List is empty! Cannot sort");
		}

		List<Shape> sortedListByArea = new ArrayList<Shape>(ShapesOnScreen);

		Collections.sort(sortedListByArea, ShapeSort.sortByArea);

		return sortedListByArea;
	}


	/**
	 * Sort The List of Shape type object According to their Perimeter.
	 * @return		An List of Shape type object sorted accordingly.
	 */
	public List<Shape> sortByPerimeter()
	{

		if(ShapesOnScreen.size() == 0) {
			throw new AssertionError("List is empty! Cannot sort");
		}

		List<Shape> sortedListByArea = new ArrayList<Shape>(ShapesOnScreen);

		Collections.sort(sortedListByArea, ShapeSort.sortByPerimeter);

		return sortedListByArea;
	}


	/**
	 * Sort The List of Shape type object According to their OriginDistance.
	 * @return		An List of Shape type object sorted accordingly.
	 */
	public List<Shape> sortByOriginDistance()
	{

		if(ShapesOnScreen.size() == 0) {
			throw new AssertionError("List is empty! Cannot sort");
		}

		List<Shape> sortedListByArea = new ArrayList<Shape>(ShapesOnScreen);

		Collections.sort(sortedListByArea, ShapeSort.sortByOriginDistance);

		return sortedListByArea;
	}


	/**
	 * Send A list of shape type object, list contain all shape enclosing a specified point.
	 * @param point		A Point class object denoting (x,y) coordinate of The point.
	 * @return			A list of shape type object.
	 */
	public List<Shape> enclosing(Point point) {

		if(ShapesOnScreen.size() == 0) {
			throw new AssertionError("List is empty! Cannot sort");
		}

		List<Shape> shapeEnclosingPoint = new ArrayList<Shape>();

		for(int index = 0; index < ShapesOnScreen.size(); index++) {
			if(ShapesOnScreen.get(index).isPointEnclosed(point))
				shapeEnclosingPoint.add(ShapesOnScreen.get(index));			
		}		
		return shapeEnclosingPoint;
	}

}
