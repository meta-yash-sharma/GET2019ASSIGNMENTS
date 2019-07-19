package RecursionAssignment;

import static org.junit.Assert.*;

import org.junit.Test;

public class NQueenProblemTestCase {

	NQueenProblem obj = new NQueenProblem();
	
	
	// Positive Test Case
	@Test
	public void NQueenProblemTest () {
		int input = 4;
		assertTrue(obj.placeQueens(input));	
	}
	
	@Test
	public void NQueenProblemTest1 () {
		int input = 8;
		assertTrue(obj.placeQueens(input));	
	}
	
	
	// Negative Test Case
	@Test
	public void NQueenProblemTest2 ( ) {
		int input = 3;
		assertFalse(obj.placeQueens(input));	
	}
	
	@Test
	public void NQueenProblemTest3 ( ) {
		int input = 1;
		assertFalse(obj.placeQueens(input));	
	}

}
