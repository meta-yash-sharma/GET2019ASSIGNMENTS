package Question3;
import java.util.Scanner;

class Square extends Shape {

	private int sideOfSquare;
	private float areaOfSquare;
	
	
	/*
	 * Compute The process of Getting Side of Square whose area have to be find.
	 * @return Assign Side value to the sideOfSquare variable of class Square.
	 */
	public void getData() {
		System.out.println("Enter the Side of Square : ");
		sideOfSquare = validate();		
	}
	
	
	/*
	 * Compute The process of Calculating Area of Square whose Side is Known.
	 * @param Side of Square, Side > 0.
	 * @return Assign area value to the area variable of class.
	 */
	public void claculateArea() {
		try
		{
			areaOfSquare = sideOfSquare*sideOfSquare;
		}
		catch(ArithmeticException e) {
			System.out.println("Area can't be calculated.");
		}
	}
	
	
	/*
	 * The process of Displaying Area of Square whose Side is known .
	 * @return Display The Area of Square.
	 */
	public void display() {
		System.out.println("Area of Square of Side "+sideOfSquare+" is : "+areaOfSquare);		
	}
	
	
	/*
	 * sending the Area of Square to user.
	 * @param Area of Square, Area > 0.
	 * @return Send the Area of Square whose sides are Known.
	 */
	public float getArea() {
		return areaOfSquare;
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