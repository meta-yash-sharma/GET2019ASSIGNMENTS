package graphicsLibrary;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class ScreenClassTest {
	
	Screen screen;
	List<Double> parameters;
	
	@Before
	public void ScreenCreate () {
		screen = new Screen(1890,1000);
		parameters = new ArrayList<Double>();
	}
	

	@Test
	public void addShapeTest() {
	parameters.add(4.0);
	parameters.add(6.0);
	Shape s1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(2, 3), parameters);
	assertTrue(screen.addShape(s1));
	parameters.clear();
	
	parameters.add(4.0);
	Shape s2 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(2, 3), parameters);
	assertTrue(screen.addShape(s2));
	
	Shape s3 = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(2, 3), parameters);
	assertTrue(screen.addShape(s3));
	}
	
	
	
	
	@Test
	public void deleteShapeTest(){
	parameters.add(4.0);
	parameters.add(6.0);
	Shape s1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(2, 3), parameters);
	assertTrue(screen.addShape(s1));
	
	assertTrue(screen.removeAllShapeOfType(ShapeType.RECTANGLE));
	}
	
	
	
	
	@Test
	public void pointEnclosingTest(){
	parameters.add(4.0);
	parameters.add(6.0);
	Shape s1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(2, 3), parameters);
	assertTrue(screen.addShape(s1));
	
	List<Shape> shapeList = screen.enclosing(new Point(3,4));
	assertEquals(shapeList.get(0).getShapeType(), screen.ShapesOnScreen.get(0).getShapeType());
	}
	
	
	
	
	@Test
	public void sortByAreaTest(){
	parameters.add(3.0);
	Shape s1 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(1,3), parameters);
	screen.addShape(s1);
	parameters.add(6.0);
	
	Shape s2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(3,5), parameters);
	screen.addShape(s2);
	
	assertEquals(screen.sortByArea().get(0).getShapeType(), ShapeType.SQUARE);
	assertEquals(screen.sortByArea().get(1).getShapeType(), ShapeType.RECTANGLE);
	}
	@Test
	public void sortByAreaNegativeTest(){
	parameters.add(10.0);
	Shape s1 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(1,3), parameters);
	screen.addShape(s1);
	parameters.add(6.0);
	
	Shape s2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(3,5), parameters);
	screen.addShape(s2);
	
	assertNotEquals(screen.sortByArea().get(0).getShapeType(), ShapeType.SQUARE);
	assertNotEquals(screen.sortByArea().get(1).getShapeType(), ShapeType.RECTANGLE);
	}
	
	
	
	
	
	@Test
	public void sortByPerimeterTest(){
		parameters.add(3.0);
		Shape s1 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(1,3), parameters);
		screen.addShape(s1);
		parameters.add(6.0);
		
		Shape s2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(3,5), parameters);
		screen.addShape(s2);
		assertEquals(screen.sortByPerimeter().get(0).getShapeType(), ShapeType.SQUARE);
		assertEquals(screen.sortByPerimeter().get(1).getShapeType(), ShapeType.RECTANGLE);
	}
	@Test
	public void sortByPerimeterNegativeTest(){
		parameters.add(3.0);
		Shape s1 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(1,3), parameters);
		screen.addShape(s1);
		parameters.add(2.0);
		
		Shape s2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(3,5), parameters);
		screen.addShape(s2);
		assertNotEquals(screen.sortByPerimeter().get(0).getShapeType(), ShapeType.SQUARE);
		assertNotEquals(screen.sortByPerimeter().get(1).getShapeType(), ShapeType.RECTANGLE);
	}
	
	
	
	
	
	@Test
	public void sortByOriginDistanceTest(){
		parameters.add(3.0);
		Shape s1 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(1,3), parameters);
		screen.addShape(s1);
		parameters.add(6.0);
		
		Shape s2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(3,5), parameters);
		screen.addShape(s2);
		assertEquals(screen.sortByOriginDistance().get(0).getShapeType(), ShapeType.SQUARE);
		assertEquals(screen.sortByOriginDistance().get(1).getShapeType(), ShapeType.RECTANGLE);
	}
	@Test
	public void sortByOriginDistanceNegativeTest(){
		parameters.add(3.0);
		Shape s1 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(3,5), parameters);
		screen.addShape(s1);
		parameters.add(6.0);
		
		Shape s2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1,3), parameters);
		screen.addShape(s2);
		assertNotEquals(screen.sortByOriginDistance().get(0).getShapeType(), ShapeType.SQUARE);
		assertNotEquals(screen.sortByOriginDistance().get(1).getShapeType(), ShapeType.RECTANGLE);
	}
	
	

}
