package TestingAndJUnit;

import static org.junit.Assert.*;
import org.junit.Test;

public class ArrOperationTest {
	
	// mirrorSectionLength method Test cases
	@Test
	public void mirrorSectionLength1() {
		ArrOperation obj1 = new ArrOperation();
		int input1[] = {7,7,7,7,4,7};
		assertEquals(4,obj1.mirrorSectionLength(input1));	
	}
	
	@Test
	public void mirrorSectionLength2() {
		ArrOperation obj1 = new ArrOperation();
		int input2[] = {1, 2, 3, 8, 9, 3, 2, 1};
		assertEquals(3,obj1.mirrorSectionLength(input2));
	}
	
	@Test
	public void mirrorSectionLength3() {
		ArrOperation obj1 = new ArrOperation();
		int input3[] = {7, 1, 4, 9, 7, 4, 1};
		assertEquals(2,obj1.mirrorSectionLength(input3));
	}
	
	@Test
	public void mirrorSectionLength4() {
		ArrOperation obj1 = new ArrOperation();
		int input4[] = {1, 4, 5, 3, 5, 4, 1};
		assertEquals(7,obj1.mirrorSectionLength(input4));
	}
	
	@Test
	public void mirrorSectionLength5() {
		ArrOperation obj1 = new ArrOperation();
		int input5[] = {1, 2, 1, 4};
		assertEquals(3,obj1.mirrorSectionLength(input5 ));
	}
	
	@Test// (expected = AssertionError.class)
	public void mirrorSectionLength6() {
		ArrOperation obj1 = new ArrOperation();
		int input6[] = {};
		try {
			assertEquals(3,obj1.mirrorSectionLength(input6));
		}
		catch (AssertionError e) {
			System.out.println("Null Array Found, Hence Assertion Error , Error in mirrorSectionLength");
		}		
	}
	
	
	
	// fixXY Method Testing
	@Test
	public void fixXY1() {
		ArrOperation obj2 = new ArrOperation();
		int input1 [] = {5, 4, 9, 4, 9, 5};
		int output1 [] = {9, 4, 5, 4, 5, 9};
		assertArrayEquals(output1,obj2.fixXY(input1,4,5));
		}
	
	@Test
	public void fixXY2() {
		ArrOperation obj2 = new ArrOperation();
		int input2 [] = {1, 4, 1, 5};
		int output2 [] = {1, 4, 5, 1};
		assertArrayEquals(output2,obj2.fixXY(input2,4,5));
	}
	
	
	@Test
	public void fixXY3() {
		ArrOperation obj2 = new ArrOperation();
		int input3 [] = {1, 4, 1, 5, 5, 4, 1};
		int output3 [] = {1, 4, 5, 1, 1, 4, 5};
		assertArrayEquals(output3,obj2.fixXY(input3,4,5));
	}
	
	@Test //(expected = AssertionError.class)
	public void fixXY4() {
		ArrOperation obj2 = new ArrOperation();
		int input4 [] = {};
		int output4 [] = {};
		try{
			assertArrayEquals(output4,obj2.fixXY(input4,4,5));
		}
		catch (AssertionError e) {
			System.out.println("Null Array Found, Hence Assertion Error, Error in fixXY");
		}		
	}
	
	@Test// (expected = AssertionError.class)
	public void fixXY5() {
		ArrOperation obj2 = new ArrOperation();
		int input5 [] = {1, 4, 1, 5, 4, 1, 5, 5};
		int output5 [] = {1, 4, 5, 1, 4, 5, 1, 5};
		try{
			assertArrayEquals(output5,obj2.fixXY(input5,4,5));
		}
		catch (AssertionError e) {
			System.out.println("Number of X and Y are Different , Hence Assertion Error, Error in fixXY");
		}		
	}
	
	@Test// (expected = AssertionError.class)
	public void fixXY6() {
		ArrOperation obj2 = new ArrOperation();
		int input6 [] = {1, 4, 1, 5, 5, 4, 1};
		int output6 [] = {1, 4, 1, 5, 5, 4, 1};
		try{
			assertArrayEquals(output6,obj2.fixXY(input6,4,4));
		}
		catch (AssertionError e) {
			System.out.println("Value Of X and Y is same, Hence Assertion Error, Error in fixXY");
		}		
	}
	
	@Test // (expected = AssertionError.class)
	public void fixXY7() {
		ArrOperation obj2 = new ArrOperation();
		int input7 [] = {1, 4, 1, 5, 5, 4, 1, 4};
		int output7 [] = {1, 4, 5, 1, 1, 4, 5, 4};		
		try{
			assertArrayEquals(output7,obj2.fixXY(input7,4,5));
		}
		catch (AssertionError e) {
			System.out.println("X at Last index of Input Array, Hence Assertion Error, Error in fixXY");
		}		
	}
	
	@Test // (expected = AssertionError.class)
	public void fixXY8() {
		ArrOperation obj2 = new ArrOperation();
		int input8 [] = {1, 4, 4, 5, 5, 4, 1};
		int output8 [] = {1, 4, 4, 5, 1, 4, 5};
				
		try{
			assertArrayEquals(output8,obj2.fixXY(input8,4,5));
		}
		catch (AssertionError e) {
			System.out.println("Two X are adjacent, Hence Assertion Error, Error in fixXY");
		}		
	}	
	
	
	
	
	
	// Test Cases for splitArray Method
	@Test
	public void splitArray1() {
		ArrOperation obj3 = new ArrOperation();		
		int input1 [] = {1, 1, 1, 2, 1};
		assertEquals(3,obj3.splitArray(input1));
		}
	
	@Test
	public void splitArray2() {
		ArrOperation obj3 = new ArrOperation();
		int input2 [] = {2, 1, 1, 2, 1};
		assertEquals(-1,obj3.splitArray(input2));		
	}
	
	@Test
	public void splitArray3() {
		ArrOperation obj3 = new ArrOperation();
		int input3 [] = {10, 10};
		assertEquals(1,obj3.splitArray(input3));		
	}
	
	@Test //(expected = AssertionError.class)
	public void splitArray4() {
		ArrOperation obj3 = new ArrOperation();
		int input4 [] = {};		
		try {
			assertEquals(1,obj3.splitArray(input4));			
		}
		catch (AssertionError e) {
			System.out.println("Null Array Found, Hence Assertion Error, Error in splitArray");
		}		
	}
	
	
	
	
	
	// Test Cases for clumpsInArray Method 
	@Test
	public void clumpsInArray1 () {
		ArrOperation obj4 = new ArrOperation();		
		int input1 [] = {1, 2, 2, 3, 4, 4};
		assertEquals(2,obj4.clumpsInArray(input1));
	}
	
	@Test
	public void clumpsInArray2 () {
		ArrOperation obj4 = new ArrOperation();		
		int input2 [] = {1, 1, 2, 1, 1};
		assertEquals(2,obj4.clumpsInArray(input2));
	}
	
	@Test
	public void clumpsInArray3 () {
		ArrOperation obj4 = new ArrOperation();		
		int input [] = {1, 1, 1, 1, 1};
		assertEquals(1,obj4.clumpsInArray(input));
	}
	
	@Test //(expected = AssertionError.class)
	public void clumpsInArray4 () {
		ArrOperation obj4 = new ArrOperation();		
		int input [] = {};
		try {
			assertEquals(10,obj4.clumpsInArray(input));
		}
		catch (AssertionError e) {
			System.out.println("Null Array Found, Hence Assertion Error, Error in clumpsInArray");			
		}
	}
}
