package uniqueCharacters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class UniqueCharacters {
	
	static HashMap<String, Set> uniqueCharactersData = new HashMap<String, Set>();
	static HashSet<Character> uniqueCharacters = new HashSet<Character>();

	/**
	 * Utility Function for
	 * @param partOfString SubString of a String
	 * @return Set containing Unique Characters of that substring
	 */
	public static HashSet<Character> countUniqueUtil(String partOfString) {
		HashSet<Character> setOfUniqueChar = new HashSet<Character>();
		for (int i = 0; i < partOfString.length(); i++) {
			// Unique Characters of that substring
			if (!setOfUniqueChar.contains(partOfString.charAt(i)))
				setOfUniqueChar.add(partOfString.charAt(i));
			// Unique Characters Overall
			if (!uniqueCharacters.contains(partOfString.charAt(i)))
				uniqueCharacters.add(partOfString.charAt(i));
		}
		// Put the string in cache memory so that the function does'nt count the
		// same sequence
		uniqueCharactersData.put(partOfString, setOfUniqueChar);
		// Return the set of unique characters in a substring
		return setOfUniqueChar;
	}

	/**
	 * This method Counts number of unique characters in input string.
	 * @param inputString
	 * @return Number of unique Characters
	 */
	public static int countUnique(String inputString) {
		if (inputString == null)
			throw new AssertionError("Enter a valid String");
		String temp = "";
		for (int i = 0; i < inputString.length(); i++) {
			// String is scanned till spaces of end of String
			if ((inputString.charAt(i) == ' ')
					|| (i == inputString.length() - 1)) {
				if (i == inputString.length() - 1)
					temp += inputString.charAt(i);
				// Check if it present in the cache
				if (uniqueCharactersData.get(temp) == null) {
					HashSet<Character> set = countUniqueUtil(temp);
					uniqueCharactersData.put(temp, set);
				}
			} else
				temp += inputString.charAt(i);
		}
		return uniqueCharacters.size();
	}

}
