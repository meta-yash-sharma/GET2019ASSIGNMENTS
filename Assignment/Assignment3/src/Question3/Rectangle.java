package Question3;
import java.util.*;

class Rectangle extends Shape {
	
	private int length;
	private int width;
	private float area;
	
	
	/*
	 * Getting Length and Width of Rectangle whose area have to be find.
	 * @return Assign length and width value to the length and width variable of class Rectangle.
	 */
	public void getData() {
			System.out.println("Enter the Length of rectangle : ");
			length = validate();

			System.out.println("Enter the Width of rectangle : ");
			width = validate();
	}
	
	
	/*
	 * Displaying Area of Rectangle whose length and width is known .
	 * @return Display The Area of Rectangle.
	 */
	public void display() {
		System.out.println("Area of Rectangle of Length "+length+" and width "+width+" is : "+area);
	}
	
	
	/*
	 * Calculating Area of Rectangle whose length and Width is given .
	 * @param Length and Width of Rectangle, length > 0, width > 0.
	 * @return Assign area value to the area variable of class.
	 */
	public void claculateArea() {
		try
		{
			area = length*width;
		}
		catch(ArithmeticException e) {
			System.out.println("Area can't be calculated.");
		}
	}
	
	
	/*
	 * sending the Area of Rectangle to user.
	 * @param Area of Rectangle, Area > 0.
	 * @return return the Area of Rectangle whose length and width is Known.
	 */
	public float getArea() {
		return (float)area;
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