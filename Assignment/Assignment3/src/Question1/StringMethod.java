package Question1;
class StringMethod {
	
	/*
	 * Compute The process of Comparing Two Given String.
	 * @param Pass A Two String.
	 * @return Return 1 if both Strings are equal and 0 if not, Both String ignore cases and 
	 * are not Null.
	 * for example compareTwoString("AbcD","aBcd") = returns 1
	 */
	int compareTwoString(String s1, String s2) {
		s1 = lowerToUpper(s1);
		//System.out.println(s1);
		s2 = lowerToUpper(s2);
		int lengthOfStringOne = s1.length();
		int lengthOfStringTwo = s2.length();
		
		if(lengthOfStringOne != lengthOfStringTwo)
			return 0;
		else
		{
			for(int i=0;i<lengthOfStringOne;i++)
			{
				if(s1.charAt(i) != s2.charAt(i))
					return 0;			
			}
			return 1;
		}
	}
	
	
	/*
	 * Compute The process of Converting Given String into its Reverse Format.
	 * @param Pass A String.
	 * @return Return reverse of the input string Passed.
	 * for example reverse("AbcD") = returns "DcbA"
	 */
	String reverse(String s1) {
		char [] temperory = s1.toCharArray();
		String reverseString = "";
		int left,right;
		left = 0;
		right = temperory.length-1;
		for(left = 0; left<right; left++,right--)
		{
			char temp = temperory[left];
			temperory[left] = temperory[right];
			temperory[right] = temp;
		}
		for(char c: temperory)
			reverseString = reverseString + c; 
		return reverseString;
	}
	
	
	/*
	 * Compute The process of Converting Given String into its Opposite case that is replace 
	 * Upper To Lower And Lower To Upper case.
	 * @param Pass A String.
	 * @return Return reverse a String whose upper case are converted into lower case and lower
	 * cases into upper case.
	 * for example replaceUperToLowerAndLowerToUpper("AbcD") = returns "aBCd"
	 */
	String replaceUperToLowerAndLowerToUpper(String s1) {
		String stringOppositeCase = "";
		int lengthOfString = s1.length();
		for(int i=0; i<lengthOfString;i++)
		{
			char c = s1.charAt(i);
			if(c >='a' && c <='z')
				stringOppositeCase =stringOppositeCase + (char)(s1.charAt(i) -32);
			else if( c >='A' && c <='Z')
				stringOppositeCase =stringOppositeCase + (char)(s1.charAt(i) +32);
			else if(c == ' ')
				stringOppositeCase = stringOppositeCase + " ";
		}
		return stringOppositeCase;
	}
	
	
	/*
	 * Compute The process of Converting Given String into its Upper case.
	 * @param Pass A String.
	 * @return Return the String Such that all whole String is In Upper Case.
	 * for example lowerToUpper("AbcD") = returns "ABCD"
	 */
	String lowerToUpper(String s1)
	{
		String stringUpperCase = "";
		int lengthOfString = s1.length();
		for(int i=0; i<lengthOfString;i++)
		{
			char c = s1.charAt(i);
			if(c >='a' && c <='z')
				stringUpperCase =stringUpperCase + (char)(s1.charAt(i) -32);
			else if( c >='A' && c <='Z')
				stringUpperCase =stringUpperCase + s1.charAt(i);
			else if(c == ' ')
				stringUpperCase = stringUpperCase + " ";
		}
		return stringUpperCase;		
	}
	
	
	/*
	 * Compute The process of sending The Largest word in the String.
	 * @param Pass A String.
	 * @return Return the word of The String with Largest Length.
	 * for example sendLargestWordOfString("Abc DE fg") = returns "Abc"
	 */
	String sendLargestWordOfString(String s1) {
		String longestWord = "";
		int lengthOfString = s1.length();
		s1 = " "+s1;
		int index=0;
		int longestWordLength = 0,currentLength = 0;
		for(int i=lengthOfString-1; i>0;i--)
		{
			if(s1.charAt(i) != ' ')
				currentLength++;
			else
			{
				if(longestWordLength < currentLength)
				{
					longestWordLength = currentLength;
					index =i;
					currentLength = 0;
				}					
			}
		}
		if(longestWordLength < currentLength)
		{
			longestWordLength = currentLength;
			index = 0;
		}
		for(int i = index+1; i < (index + longestWordLength+1); i++)
		{
			longestWord = longestWord + s1.charAt(i); 
		}
		return longestWord;
	}
	
}