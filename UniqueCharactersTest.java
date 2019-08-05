package uniqueCharacters;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UniqueCharactersTest {

	/**
	 * Positive Test case for Unique Characters
	 */
	@Test
	public void test1() {
		String checkString = "Yash is a Yash boy";
		int actual = UniqueCharacters.countUnique(checkString);
		assertEquals(9, actual);
	}
}
