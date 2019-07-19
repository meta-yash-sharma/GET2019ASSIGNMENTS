package RecursionAssignment;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathsProblemTestCase {
	
	MathsProblem obj = new MathsProblem();

	//  HCF Test Cases.
	// Positive Test Case
	@Test
	public void hcf () {
		int input1 = 10;
		int input2 = 50;
		assertEquals(10,obj.hcf(input1, input2));	
	}
	
	// Negative Test Case
	@Test
	public void hcf1 () {
		int input1 = 10;
		int input2 = 50;
		assertNotEquals(5,obj.hcf(input1, input2));	
	}
	
	//  LCM Test Cases.
	// Positive Test Case
	@Test
	public void lcm () {
		int input1 = 15;
		int input2 = 25;
		assertEquals(75,obj.lcm(input1, input2));	
	}
	@Test
	public void lcm1 () {
		int input1 = 10;
		int input2 = 50;
		assertEquals(50,obj.lcm(input1, input2));	
	}
	
	// Negative Test Case
	@Test
	public void lcm2 () {
		int input1 = 10;
		int input2 = 50;
		assertNotEquals(10,obj.lcm(input1, input2));	
	}
	@Test
	public void lcm3 () {
		int input1 = 15;
		int input2 = 25;
		assertNotEquals(10,obj.lcm(input1, input2));	
	}

}
