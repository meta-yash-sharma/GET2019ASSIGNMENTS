package RecursionAssignment;

public class MathsProblem {
	
	 
	static int value = 1;
	
	/**
	 * L.C.M. of two Integer numbers number1 and number2
	 * @param number1 An positive integer number. 
	 * @param number2 An positive integer number. 
	 * @return return us the Least Common Multiple of two Positive Integer passed as parameter in it. 
	 */
	public int lcm(int number1, int number2) {
		if(value % number1 == 0 && value % number2 == 0)
			return value;
		value++;
		lcm(number1,number2);
		return value;
	}
	
	
	/**
	 * H.C.F of two Integer numbers number1 and number2
	 * @param number1 An positive integer number.
	 * @param number2 An positive integer number.
	 * @return send us the H.C.F of two Positive Integer passed as parameter in it.
	 */
	public int hcf(int number1, int number2) {
		if(number1 == 0)
			return number2;
		return hcf(number2%number1, number1);
	}
}