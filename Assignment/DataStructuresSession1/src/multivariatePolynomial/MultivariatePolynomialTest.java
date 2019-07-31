package multivariatePolynomial;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;



public class MultivariatePolynomialTest {

List<PolynomialTerm> termList = new ArrayList<>();
	
	/**
	 * This method initializes the term list before any test is executed
	 */
	@Before
	public void initialize()
	{
		List<Polynomial> variable1 = new ArrayList<>();
		variable1.add(new Polynomial('x', 2));
		variable1.add(new Polynomial('y', 1));
		variable1.add(new Polynomial('z', 1));
		
		List<Polynomial> variable2 = new ArrayList<>();
		variable2.add(new Polynomial('x', 3));
		variable2.add(new Polynomial('y', 2));
		
		PolynomialTerm term1 = new PolynomialTerm(4, variable1);
		PolynomialTerm term2 = new PolynomialTerm(3, variable2);
		
		termList.add(term1);
		termList.add(term2);
	}
	
	//Test method to test visualizePolynomial method
	@Test
	public void testVisualizePolynomial()
	{
		MultivariatePolynomial polynomialObject = new MultivariatePolynomial(termList);
		String polynomialString = polynomialObject.displayPolynomial();
		String expectedPolynomialString = "4*x^2*y^1*z^1 + 3*x^3*y^2";
		assertEquals(expectedPolynomialString, polynomialString);
	}

	//Test method to test degreeOfPolynomial method
	@Test
	public void testDegreeOfPolynomial()
	{
		MultivariatePolynomial polynomialObject = new MultivariatePolynomial(termList);
		assertEquals(5, polynomialObject.calculatePolynomialDegree());
	}
}
