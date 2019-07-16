package Question3;
import java.util.Scanner;

class Triangle extends Shape {

	private int heightOfTriangle;
	private int widthOfTriangle;
	private float area;
	
	
	/*
	 * Compute The process of Getting Height and Width of a Triangle whose area have to be find.
	 * @return Assign Height and Width value to the heightOfTriangle and widthOfTriangle variable of class Triangle.
	 */
	public void getData() {
		System.out.println("Enter the Height of Triangle : ");
		heightOfTriangle = validate();
		
		System.out.println("Enter the Width of Triangle : ");
		widthOfTriangle = validate();
	}
	
	
	/*
	 * The process of Displaying Area of Triangle whose Height and width are known .
	 * @return Display The Area of Triangle.
	 */
	public void display() {
		System.out.println("Area of Triangle with Height "+heightOfTriangle+" and width "+widthOfTriangle+" is : "+area);		
	}
	
	
	/*
	 * Calculating Area of Triangle whose Height and Width are Known.
	 * @param Height and width of triangle, height,width > 0.
	 * @return Assign area value to the area variable of class.
	 */
	public void claculateArea() {
		try
		{
			area = (heightOfTriangle*widthOfTriangle)/2;
		}
		catch(ArithmeticException e) {
			System.out.println("Area can't be calculated.");
		}
	}
	
	
	/*
	 * sending the Area of Triangle to user.
	 * @param Area of Triangle, Area > 0.
	 * @return Send the Area of Triangle, whose height and width are Known.
	 */
	public float getArea() {
		return area;
	}
	
	
	/*
	 * Validating whether the given value is Integer.
	 * @param Take input from user of any type
	 * @return send an Integer value, which is positive and greater than zero.
	 */
	public int validate()
	{
		int validateInteger;
		boolean validate = true;
		Scanner sc = new Scanner(System.in);
		do{
		while(!sc.hasNextInt()){
			System.out.println("Please Enter integer Value : ");
			sc.next();
		}
		validateInteger = sc.nextInt();
		if( validateInteger > 0)
				validate= false;
		else
				System.out.println("Integer Value Can't be Negative or zero.");						
		}while(validate);
		return validateInteger;		
	}
}