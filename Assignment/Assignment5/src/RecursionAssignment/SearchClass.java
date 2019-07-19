package RecursionAssignment;

public class SearchClass {
	
	/**
	 * Linear search is a method for finding a target value within an array. 
	 * It sequentially checks each element of the array for the target value 
	 * until a match is found or until all the elements have been searched.
	 * @param inputArray An integer Array in which the target value is to be fined.
	 * @param numberToSearch An integer number also Known as the target value to be found in array.
	 * @param index1 an Integer value An index from which we have to start search.
	 * @return return index value if the element is found in array otherwise returns -1.
	 */
	public int linearSearch(int [] inputArray, int numberToSearch, int index1) {
		
		if(index1 >= inputArray.length)
			return -1;
		else if(inputArray[index1] == numberToSearch)
			return index1;
		index1++;		
		return linearSearch(inputArray, numberToSearch,index1+1);
	}
	
	
	/**
	 * Binary search is a search algorithm that finds the position of a target value 
	 * within a sorted array. 
	 * @param inputArray An integer Array in which the target value is to be fined.
	 * @param numberToSearch An integer number also Known as the target value to be found in array.
	 * @param firstIndex index value from where array start.
	 * @param lastIndex index value of last index of array
	 * @return return index value if the element is found in array otherwise returns -1.
	 */
	public int binarySearch(int [] inputArray, int numberToSearch ,int firstIndex , int lastIndex) {
		
		if(lastIndex >= firstIndex) {
			int midIndex = firstIndex +(lastIndex - firstIndex)/2;
			
			if(inputArray[midIndex] == numberToSearch)
				return midIndex;
			
			if(inputArray[midIndex] > numberToSearch)
				return binarySearch(inputArray,numberToSearch,firstIndex,midIndex-1);
			
			return binarySearch(inputArray,numberToSearch,midIndex+1,lastIndex);			
		}
		return -1;
	}
}