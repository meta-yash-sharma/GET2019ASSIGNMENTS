package Question1;

import java.util.*;

class StringCall {
	
	public static void main(String[] args) {
		StringMethod string = new StringMethod();
		String string1,string2,reverseString1,reverseString2,stringOppositeCase1,stringOppositeCase2;
		String longestWordOfString1,longestWordOfString2;
		int equalCheck;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter First String : ");
		string1 = sc.nextLine();
		System.out.println("Enter Second String : ");
		string2 = sc.nextLine();
		
		// Compare Two String
		equalCheck = string.compareTwoString(string1, string2);
		if(equalCheck == 1)
			System.out.println("Two String Are Equal.");
		else
			System.out.println("Two String Are Not Equal.");
		
		
		// Reverse Of The Given String.
		reverseString1 = string.reverse(string1);
		System.out.println("Reverse Of String 1 : "+reverseString1);
		reverseString2 = string.reverse(string2);
		System.out.println("Reverse Of String 2 : "+reverseString2);
		
		
		// Do Opposite case For the Given String.
		stringOppositeCase1 = string.replaceUperToLowerAndLowerToUpper(string1);
		System.out.println("Replace Uper To Lower And Lower To Upper Case Of String 1 : "+stringOppositeCase1);
		stringOppositeCase2 = string.replaceUperToLowerAndLowerToUpper(string2);
		System.out.println("Replace Uper To Lower And Lower To Upper Case Of String 2 : "+stringOppositeCase2);
		
		
		// Longest Word Of The Given String. 
		longestWordOfString1 = string.sendLargestWordOfString(string1);
		System.out.println("Longest Word Of String One is : "+longestWordOfString1);
		longestWordOfString2 = string.sendLargestWordOfString(string2);
		System.out.println("Longest Word Of String Two is : "+longestWordOfString2);
		
		
		
		sc.close();		
	}
}