package hexCal;
import java.lang.String;

public class HexNumber implements BasicNumberClass {
	
	/*
	 * Compute The process of Converting Hexadecimal Number into Decimal Number.
	 * @param Pass A Hexadecimal Number in A Form Of A String.
	 * @return Return the Decimal value of the Given Hexadecimal String.
	 * for example hexToDec("A") = returns 10
	 */
	public int hexToDec(String hexNumber)
	{
		int lenOfString = hexNumber.length();
		int base=1;
		int decimalNumber=0;		
		for(int i=lenOfString-1; i>=0; i--)
		{
			if(hexNumber.charAt(i)>='0' && hexNumber.charAt(i)<='9')
			{
				decimalNumber += (hexNumber.charAt(i)-48)*base;
				base = base*16;
			}
			else if(hexNumber.charAt(i)>='A' && hexNumber.charAt(i)<='F')
			{
				decimalNumber += (hexNumber.charAt(i)-55)*base;
				base = base*16;
			}
			else
			{
				System.out.println("Invalid Input.");
				return -1;
			}
		}		
		return decimalNumber;
	}
	/*
	 * Compute The process of Converting Decimal Number into a Hexadecimal Number.
	 * @param Pass An Integer Decimal Number as an Input .
	 * @return Return the Hexadecimal value of the given decimal number in a form of String.
	 * for example decToHex(10) = returns "A"
	 */
	public String decToHex(int DeccimalNumber)
	{
		int base = 16;
		String hexNumber= "";
		char hexChar[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		int remainder;
		while(DeccimalNumber > 0)
		{
			remainder = DeccimalNumber%base;
			hexNumber = hexChar[remainder]+ hexNumber;
			DeccimalNumber = DeccimalNumber/base;
		}		
		return hexNumber;
	}
	/*
	 * Add Two Hexadecimal Number and return their Addition value.
	 * @param Pass Two Hexadecimal number in a Form of String.
	 * @return Return the Hexadecimal Addition value of The given Two Number in String Format.
	 * for example addToHexNumber("A","2") = returns "C"
	 */
	public String addToHexNumber(String hexNumberOne, String hexNumberTwo)
	{
		int decNumber1,decNumber2;
		decNumber1 = hexToDec(hexNumberOne);
		decNumber2 = hexToDec(hexNumberTwo);
		return decToHex(decNumber1 + decNumber2);		
	}
	/*
	 * Subtract Two Hexadecimal Number and return their Subtract value.
	 * @param Pass Two Hexadecimal number in a Form of String.
	 * @return Return the Hexadecimal Subtraction value of The given Two Number in String Format.
	 * for example subToHexNumber("A","2") = returns "8"
	 */
	public String subToHexNumber(String hexNumberOne, String hexNumberTwo)
	{
		int decNumber1,decNumber2;
		int subOfDecNumber;
		decNumber1 = hexToDec(hexNumberOne);
		decNumber2 = hexToDec(hexNumberTwo);		
		subOfDecNumber = decNumber1 - decNumber2;
		if(subOfDecNumber != 0)
		{
			if(subOfDecNumber > 0)
				return decToHex(subOfDecNumber);
			else
				return "-"+decToHex(-subOfDecNumber);			
		}
		else
			return "0";
	}
	/*
	 * Multiply Two Hexadecimal Number and return the Multiple Of Two Variable.
	 * @param Pass Two Hexadecimal number in a Form of String.
	 * @return Return the Hexadecimal Multiplication value of The given Two Number in String Format.
	 * for example subToHexNumber("4","3") = returns "C"
	 */
	public String multiplyToHexNumber(String hexNumberOne, String hexNumberTwo)
	{
		int decNumber1,decNumber2;
		int multipleOfToDecNumber;		
		decNumber1 = hexToDec(hexNumberOne);
		decNumber2 = hexToDec(hexNumberTwo);		
		multipleOfToDecNumber = decNumber1*decNumber2;
		if(multipleOfToDecNumber == 0)
			return "0";		
		return decToHex(multipleOfToDecNumber);		
	}
	/*
	 * Divide Two Hexadecimal Number and return the Division Of Two Variable.
	 * @param Pass Two Hexadecimal number in a Form of String.
	 * @return Return the Hexadecimal Division value of The given Two Number up to 0 decimal value in String Format.
	 * for example subToHexNumber("A","3") = returns "3"
	 */
	public String divideToHexNumber(String hexNumberOne, String hexNumberTwo)
	{
		int decNumber1,decNumber2;
		int divideOfToDecNumber;		
		decNumber1 = hexToDec(hexNumberOne);
		decNumber2 = hexToDec(hexNumberTwo);
		try
		{
			divideOfToDecNumber = decNumber1/decNumber2;		
			if(divideOfToDecNumber == 0)
				return "0";		
			return decToHex(divideOfToDecNumber);						
		}
		catch(ArithmeticException e) {
			System.out.println("Can't Divide a Number by 0.");
		}
		return null;		
	}
	/*
	 * Compare The Two Hexadecimal number For checking whether they are Equal or not.
	 * @param Pass Two Hexadecimal number in a Form of String.
	 * @return Return True if Two hexadecimal values are equal else False.
	 * for example subToHexNumber("A","3") = returns false
	 */
	public boolean equalToHexNumber(String hexNumberOne, String hexNumberTwo)
	{
		int lengthOfFirstNumber = hexNumberOne.length();
		int lengthOfSecondNumber = hexNumberTwo.length();
		if(lengthOfFirstNumber != lengthOfSecondNumber)
			return false;
		else
		{
			boolean flag = false;
			for(int i=0;i<lengthOfFirstNumber;i++)
			{
				if(hexNumberOne.charAt(i) != hexNumberTwo.charAt(i))
					flag=true;				
			}
			if(flag)
				return false;
			else
				return true;
		}
	}
	/*
	 * Compare The Two Hexadecimal number For checking whether they First number is greater or Second Number is greater.
	 * @param Pass Two Hexadecimal number in a Form of String.
	 * @return Return True if First Number is Greater Than Second Number else False.
	 * for example subToHexNumber("A","3") = returns True
	 */
	public boolean isGreaterToSecondHexNumber(String hexNumberOne, String hexNumberTwo)
	{
		int lengthOfFirstNumber = hexNumberOne.length();
		int lengthOfSecondNumber = hexNumberTwo.length();
		if(lengthOfFirstNumber > lengthOfSecondNumber)
			return true;
		else if(lengthOfFirstNumber < lengthOfSecondNumber)
			return false;
		else
		{
			for(int i=0;i<lengthOfFirstNumber;i++)
			{
				if(hexNumberOne.charAt(i) > hexNumberTwo.charAt(i))
					break;
				else if(hexNumberOne.charAt(i) < hexNumberTwo.charAt(i))
					return false;
			}
		}
		return true;
	}	
}







