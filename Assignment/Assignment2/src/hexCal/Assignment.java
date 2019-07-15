package hexCal;

import java.util.Scanner;

public class Assignment {
	/** 
	 * This is the main method which is Used To take Two HexaDecimal as Input and Perform
	 * different operations such as Addition,Subtraction,Multiplication,Compare on these Hexadecimal
	 * Numbers by Calling Different methods from Class HexNumber. 
	 * @param args Unused. 
	 * @return Nothing. 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HexNumber hexdecimal = new HexNumber() ;
		int decimalNumber;
		int decimalNumberTwo;
		String hexDecimalNumber = new String();
		String hexDecimalNumberTwo = new String();
		String inputHexNumber;
		String inputHexNumberTWO;
		String addHexNumber;
		String subHexNumber;
		String multipleOfHexNumber;
		String divideOfHexNumber;
		String decToHex;
		int inputDecimalNumber;
		boolean toHexNumberEqual;
		boolean toCheckFirstHexNumberGreater;

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter an Hex-decimal Number One : ");
		inputHexNumber = sc.nextLine();
		inputHexNumber = inputHexNumber.toUpperCase();
		decimalNumber = hexdecimal.hexToDec(inputHexNumber);
		if(decimalNumber == -1)
			System.exit(0);
		hexDecimalNumber = inputHexNumber;

		System.out.println("Enter an Hex-decimal Number Two : ");
		inputHexNumberTWO = sc.nextLine();
		inputHexNumberTWO = inputHexNumberTWO.toUpperCase();
		decimalNumberTwo = hexdecimal.hexToDec(inputHexNumberTWO);
		if(decimalNumberTwo == -1)
			System.exit(0);
		hexDecimalNumberTwo = inputHexNumberTWO;
		System.out.println("Decimal converter used. Number one : "+decimalNumber+" Number two : "+decimalNumberTwo);

		addHexNumber = hexdecimal.addToHexNumber(hexDecimalNumber, hexDecimalNumberTwo);
		System.out.println("Add of Two Hex-Decimal Number is : "+addHexNumber);

		subHexNumber = hexdecimal.subToHexNumber(hexDecimalNumber, hexDecimalNumberTwo);
		System.out.println("Sub of Two Hex-Decimal Number is : "+subHexNumber);

		multipleOfHexNumber = hexdecimal.multiplyToHexNumber(hexDecimalNumber, hexDecimalNumberTwo);
		System.out.println("Multiple of Two Hex-Decimal Number is : "+multipleOfHexNumber);

		divideOfHexNumber = hexdecimal.divideToHexNumber(hexDecimalNumber, hexDecimalNumberTwo);
		if(divideOfHexNumber != null)
			System.out.println("Divide of Two Hex-Decimal Number is : "+divideOfHexNumber);

		toHexNumberEqual = hexdecimal.equalToHexNumber(hexDecimalNumber, hexDecimalNumberTwo);
		if(toHexNumberEqual)
			System.out.println("Two Hex-Decimal Number are Equal.");
		
		toCheckFirstHexNumberGreater = hexdecimal.isGreaterToSecondHexNumber(hexDecimalNumber, hexDecimalNumberTwo);
		if(toCheckFirstHexNumberGreater && !toHexNumberEqual)
			System.out.println("First Number is Greater than Second Hex number.");
		else
			System.out.println("Second Number is Greater than First Hex number.");
		
		
		
		try{
			System.out.println("Enter Decimal number to be converted into Hexdecimal.");
			inputDecimalNumber = sc.nextInt();
			decToHex = hexdecimal.decToHex(inputDecimalNumber);
			System.out.println("Hex-decimal of decimal value "+inputDecimalNumber+" is "+decToHex);
		}
		catch(NumberFormatException nfe)
		{
			nfe.printStackTrace();
		}
		
		sc.close();
	}

}
