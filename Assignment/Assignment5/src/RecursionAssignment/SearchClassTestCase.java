package RecursionAssignment;

import static org.junit.Assert.*;

import org.junit.Test;


public class SearchClassTestCase {
	
	SearchClass obj = new SearchClass();

	// Linear Search Cases.
	// Positive Test Case
	@Test
	public void linearSearch() {
		int input1[] = {7,7,7,7,4,7};
		assertEquals(4,obj.linearSearch(input1, 4, 0));	
	}
	
	@Test
	public void linearSearch1() {
		int input1[] = {1,7,3,10,4,20};
		assertEquals(0,obj.linearSearch(input1, 1, 0));	
	}
	
	@Test
	public void linearSearch2 () {
		int input1[] = {1,7,3,10,4,20};
		assertEquals(-1,obj.linearSearch(input1, 5, 0));	
	}
	
	// Negative Test Case
	@Test
	public void linearSearch3 () {
		int input1[] = {1,7,3,10,4,20};
		assertNotEquals(1,obj.linearSearch(input1, 5, 0));	
	}
	@Test
	public void linearSearch4 () {
		int input1[] = {1,7,3,10,4,20};
		assertNotEquals(0,obj.linearSearch(input1, 7, 0));	
	}
	
	
	// Binary Search Cases
	// Positive Test Cases
	@Test
	public void binarySearch() {
		int input1[] = {1,2,3,4,5,6,7};
		assertEquals(3,obj.binarySearch(input1, 4, 0, 6));	
	}
	
	@Test
	public void binarySearch2 () {
		int input1[] = {1,3,7,9,15,16,25};
		assertEquals(5,obj.binarySearch(input1, 16, 0, 6));	
	}
	
	
	@Test
	public void binarySearch3() {
		int input1[] = {1,2,3,4,5,6,7};
		assertEquals(-1,obj.binarySearch(input1, 25, 0, 6));	
	}
	// Negative Test Case
	@Test
	public void binarySearch4() {
		int input1[] = {1,2,3,4,5,6,7};
		assertNotEquals(1,obj.binarySearch(input1, 25, 0, 6));	
	}
	
	@Test
	public void binarySearch5() {
		int input1[] = {1,2,3,4,5,6,7};
		assertNotEquals(5,obj.binarySearch(input1, 1, 0, 6));	
	}

}
