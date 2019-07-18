package TestingAndJUnit;

import java.util.ArrayList;
import java.util.List;


class ArrOperation {
	
	/**
	 * Mirror section in an array is a group of contiguous elements such that somewhere in the array, 
	 * the same group appears in reverse order.
	 * @param inputArray An Integer Array.
	 * @return length of the mirror section in the inputArray.
	 * @throws AssertionError
	 * Assumption Array are of positive integers values.
	 */
	public int mirrorSectionLength (int [] inputArray) throws AssertionError {
		if(inputArray.length == 0) {
			// throw AssertionError
			throw new AssertionError("Null Array Found.");			
		}
		int mirrorLength = 0;
		int arrayLength = inputArray.length;
		
		for(int index1 = 0 ; index1 < arrayLength; index1++) {
			boolean mirrorFlag = false; // to check when mirror start
			int length=0;
			int indexCheck = index1;
			for(int index2 = arrayLength-1 ; index2 >= 0 && indexCheck < arrayLength ; index2--) {
				if(inputArray[indexCheck] == inputArray[index2] && !(mirrorFlag)) {
					mirrorFlag = true;
					indexCheck++;
					length++;
				}
				else if(inputArray[indexCheck] == inputArray[index2] && mirrorFlag) {
					indexCheck++;
					length++;
					if(mirrorLength < length)
						mirrorLength = length;
				}
				else if(inputArray[indexCheck] != inputArray[index2] && mirrorFlag) {
					mirrorFlag = false;
					length = 0;
					indexCheck = index1;
				}
				else if(index2 == indexCheck && (index2-indexCheck)== 1) {
					mirrorFlag = false;
					break;
				}
			}
		}
		
		return mirrorLength;
	}
	
	
	/**
	 * Clump in an array is a series of 2 or more adjacent elements of the same value.
	 * @param inputArray An Integer Array.
	 * @return number of Clumps in inputArray.
	 * @throws AssertionError
	 */
	public int clumpsInArray(int [] inputArray) throws AssertionError {
		if(inputArray.length == 0) {
			throw new AssertionError("Null array found");
		}
		int clumps = 0;
		int clumpsLength =0;
		int inArrLen = inputArray.length;
		for(int index = 0; index < inArrLen-1; index++) {
			if(inputArray[index] == inputArray[index+1]) {
				clumpsLength++;
			}
			else {
				if(clumpsLength > 0) {
					clumps++;
					clumpsLength = 0;
				}	
			}
		}
		if(clumpsLength > 0) {
			clumps++;			
		}
		return clumps;
	}
	
	
	/**
	 * Rearranged an array such that every X is immediately followed by a Y, And X does not change position.
	 * @param inArray An Integer Array.
	 * @param x An Integer variable, Position can't changed in array.
	 * @param y An Integer variable, Position rearranged such that it is just after variable x.
	 * @return An rearranged array such that every X is immediately followed by a Y, 
	 * And X does not change position.
	 */
	public int[] fixXY(int [] inArray, int x, int y) throws AssertionError {
		if(inArray.length == 0) {
			// throw AssertionError
			throw new AssertionError("Null Array Found.");			
		}
		if(x== y) {
			throw new AssertionError("X and Y variable value same.");
		}
		int [] opArray = new int[inArray.length];
		opArray = inArray;
		List<Integer> indexOfX = new ArrayList<Integer>();
		List<Integer> indexOfY = new ArrayList<Integer>();
		int numberOfX = 0;
		int numberOfY = 0;
		
		for(int index1 = 0; index1 < inArray.length; index1++) {
			if(inArray[index1] == x) {
				indexOfX.add(index1);
				numberOfX++;
			}
				
			else if(inArray[index1] == y) {
				indexOfY.add(index1);
				numberOfY++;
			}
		}
		
		if(numberOfX == numberOfY) {
			if(inArray[inArray.length-1] == x) {
				// throw exception
				throw new AssertionError("x variable at the last index of input array.");
			}
			else {
				boolean adjacentIndex = false;
				for(int index2 = 0; index2 < numberOfX-1 ; index2++) {
					int x1 = indexOfX.get(index2); 
					int y1 = indexOfX.get(index2+1);
					if(x1 == (y1-1)) {
						adjacentIndex = true;
					}
					
				}
				if(adjacentIndex) {
					// throw exception
					throw new AssertionError("two or more adjacent x in array.");
				}
				else {
					for(int index3 = 0; index3 < numberOfX; index3++) {
						int postionX = indexOfX.get(index3);
						int postionY = indexOfY.get(index3);
						opArray[postionY] = opArray[postionX +1];
						opArray[postionX +1] = y;
					}
				}
			}
		}
		else {
			//throw exception
			throw new AssertionError("Number of x and y is same.");
		}
		
		return opArray;
	}
	
	
	/**
	 * Split an Integer array such that sum of the numbers on one side is equal to the sum of 
	 * the numbers on the other side
	 * @param inArray An Integer Array.
	 * @return index i of inArray such that sum of the numbers on one side is equal to the sum of 
	 * the numbers on the other side else return -1.
	 */
	public int splitArray(int [] inArray) throws AssertionError {
		if(inArray.length == 0) {
			throw new AssertionError("Null Array Found.");
		}
		int indexSplit = -1;
		int leftSum = 0, rightSum = 0;
		for(int loopIndex1 = 0; loopIndex1 < inArray.length; loopIndex1++)
			leftSum += inArray[loopIndex1];
		for(int loopIndex2 = inArray.length-1; loopIndex2 >= 0; loopIndex2--) {
			rightSum += inArray[loopIndex2];
			
			leftSum -= inArray[loopIndex2];
			
			if(rightSum == leftSum)
				indexSplit = loopIndex2;
		}
		return indexSplit;
	}
}