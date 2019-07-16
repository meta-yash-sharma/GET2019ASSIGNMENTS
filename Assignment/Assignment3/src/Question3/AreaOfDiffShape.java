package Question3;

public class AreaOfDiffShape {

	public static void main(String[] args) {
		
		// For Circle
		Circle shape1;
		float circleArea;
		shape1 = new Circle();
		shape1.getData();
		shape1.claculateArea();
		shape1.display();
		circleArea = shape1.getArea();
		System.out.println(circleArea);

		
		// For Rectangle
		Rectangle shape2 = new Rectangle();
		float rectangleArea;
		shape2.getData();
		shape2.claculateArea();
		shape2.display();
		rectangleArea = shape2.getArea();
		System.out.println(rectangleArea);
		
		
		// For Square
		Square shape3;
		float squareArea;
		shape3 = new Square();
		shape3.getData();
		shape3.claculateArea();
		shape3.display();
		squareArea = shape3.getArea();
		System.out.println(squareArea);
		
		
		// For Triangle
		Triangle shape4;
		float triangleArea;
		shape4 = new Triangle();
		shape4.getData();
		shape4.claculateArea();
		shape4.display();
		triangleArea = shape4.getArea();
		System.out.println(triangleArea);		
	}

}
