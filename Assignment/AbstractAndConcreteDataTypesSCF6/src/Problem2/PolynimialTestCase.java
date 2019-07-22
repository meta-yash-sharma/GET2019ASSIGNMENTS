package Problem2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolynimialTestCase {

	@Test
	public void Poly () {
		int [] array = {1,2,3,4};
		int [] array2 = {0,7,6};
		
		Poly p1 = new Poly(3,array);
		Poly p2 = new Poly(2,array2);
		
		//double ans = p1.evaluate(2);
		//System.out.println(ans);
		assertEquals(49.0,p1.evaluate(2),0.00);		
		
		
		int [] addArray = {1,9,9,4}; 
		assertArrayEquals(addArray,p1.addPoly(p1, p2));		
		for(int i = addArray.length-1; i >= 0 ; i--)
			System.out.print(addArray[i]+"X^"+i+" ");
		System.out.println();
		
		
		
		int [] multiplyPoly = {0,7,20,33,46,24};
		assertArrayEquals(multiplyPoly,p1.mulPoly(p1, p2));
		for(int i = multiplyPoly.length-1; i >= 0 ; i--)
			System.out.print(multiplyPoly[i]+"X^"+i+" ");
	}

}
