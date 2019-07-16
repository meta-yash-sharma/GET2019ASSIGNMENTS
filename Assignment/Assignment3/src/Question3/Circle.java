package Question3;
import java.util.Scanner;

class Circle extends Shape {
	
	private int radius;
	private float area;
	
	/*
	 * Getting Radius of circle whose area have to be find.
	 * @param find the radius of circle radius > 0.
	 * @return Assign radius value to the radius variable of class.
	 */
	public void getData() {
			System.out.println("Enter Radius of Circle : ");
			radius = validate();		
	}
	
	
	/*
	 * Calculating Area of circle whose Radius is given .
	 * @param Radius of circle, radius > 0.
	 * @return Assign area value to the area variable of class.
	 */
	public void claculateArea() {
		try
		{
			area = pi*radius*radius;
		}
		catch(ArithmeticException e) {
			System.out.println("Area can't be calculated.");
		}
	}
	
	
	/*
	 * Displaying Area of circle whose Radius is known .
	 * @return Display The Area and Radius of Circle.
	 */
	public void display() {
		System.out.println("Area Of Circle with radius "+radius+" is : "+area);				
	}
	
	
	/*
	 * sending the Area of circle to user.
	 * @param Area of circle, Area > 0.
	 * @return return the Area of circle whose radius is Known.
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