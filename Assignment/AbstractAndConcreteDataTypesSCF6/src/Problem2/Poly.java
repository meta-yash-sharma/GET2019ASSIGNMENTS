package Problem2;

public final class Poly {
	
	private final int highestDegree;
	private final int[] polynomial;

	/**
	* Constructor 
	* @param highest_degree		An Integer variable, Send us the Degree Of Polynomial.
	* @param polynomial			An Integer Array, Send us the Coefficient of 
	* polynomial at different degree.
	*/
	public Poly(int highest_degree, int[] polynomial) {
		this.highestDegree = highest_degree;
		this.polynomial = polynomial;
		}
	
	
	public double evaluate(float x) {
		double sum = 0;
			for (int i = 0; i <= highestDegree; i++) {
				sum = sum + (polynomial[i] * Math.pow(x, i));
			}
		return sum;
		}

	/**
	* This methods return the degree of the polynomial
	* @return Degree	An Integer value, returns Degree Of The Polynomial which 
	* call this method.
	*/
	public int degree() {
		return highestDegree;
		}

	/**
	* This method adds two polynomials
	* @param poly1		The value Of Data Type Poly, The First Polynomial To be added.
	* @param poly2		The value Of Data Type Poly, The First Polynomial To be added.
	* @return			Returns An Integer Array that stores the Sum of two Polynomial.
	*/
	public int[] addPoly(Poly poly1, Poly poly2) {
		int degPolyOne = poly1.polynomial.length;
		int degPolyTwo = poly2.polynomial.length;
		int degPolyAdd;
		if (degPolyOne >= degPolyTwo)
			degPolyAdd = degPolyOne;
		else
			degPolyAdd = degPolyTwo;
		int[] additionPoly = new int[degPolyAdd]
			for (int i = 0; i < degPolyOne; i++)
				additionPoly[i] = poly1.polynomial[i];
			for (int i = 0; i < degPolyTwo; i++)
				additionPoly[i] += poly2.polynomial[i];
		return additionPoly;
		}

	/**
	* This method multiplies 2 Polynomials
	* 
	* @param poly1		The value Of Data Type Poly, The First Polynomial To be Multiplied.	
	* @param poly2		The value Of Data Type Poly, The Second Polynomial To be Multiplied.
	* @return			An Integer Array That stores The Coffecient Of 
	* Multiple of Two Polynomial.
	*/
	public int[] mulPoly(Poly poly1, Poly poly2) {
		int degPolyOne = poly1.polynomial.length;
		int degPolyTwo = poly2.polynomial.length;
		int degPolyProduct = degPolyOne + degPolyTwo-1;

		int[] product = new int[degPolyProduct];
			for (int i = 0; i < degPolyProduct; i++)
				product[i] = 0;
			for (int i = 0; i < degPolyOne; i++) {
				for (int j = 0; j < degPolyTwo; j++) {
					product[i + j] += poly1.polynomial[i] * poly2.polynomial[j];
				}
			}
		return product;
		}
}
