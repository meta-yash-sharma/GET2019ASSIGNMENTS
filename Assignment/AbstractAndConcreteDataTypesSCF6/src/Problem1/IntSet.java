package Problem1;

public class IntSet {
	
	private int [] setArray;
	private final int size;
	
	
	/**
	 * Assign the Input array to SetArray of IntSet Class Variable and
	 * size variable is assign the length of input Array.
	 * @param array		An Integer Array, Whose values we have to 
	 * assign to setArray variable of class IntSet.
	 */
	public IntSet(int [] array) {
		size = array.length;
		setArray = array;
	}
	
	
	/**
	 * 
	 * @param x		An Integer number, The value we have to check 
	 * whether it belongs to given Set or Not. 
	 * @return		True if The x is the member of set, else False.
	 */
	public boolean isMember(int x) {
		boolean isMemberOfSet = false;
		for(int index = 0; index < size; index++) {
			if(setArray[index] == x) {
				isMemberOfSet = true;
				break;
			}
		}
		return isMemberOfSet;
	}
	
	/**
	 * 
	 * @return		Return the size of Set of The integer array.
	 */
	public int size() {
		return size;
	}
	
	
	/**
	 * 
	 * @param set1		The First Set of the two Set whose union we have to find.	
	 * @param set2		The Second Set of the two Set whose union we have to find.
	 * @return			The Integer array which stores the data of union of 
	 * Set1 and Set2 integer array.
	 */
	public int[] union(IntSet set1, IntSet set2) {
		//System.out.println(set1.size);
		int a=0;
		for(int index1 = 0; index1 < set2.size; index1++)
			if(!set1.isMember(set2.setArray[index1]))
				a++;
			
		int [] array = new int[set1.size + a];
		int index = 0;
		for(int index1 = 0; index1 < set1.size; index1++) {
			array[index] = set1.setArray[index1];
			index++;
		}
		for(int index1 = 0; index1 < set2.size; index1++) {
			if(!set1.isMember(set2.setArray[index1])) {
				array[index] = set2.setArray[index1];
				index++;
			}
		}
		return array;
	}
	
	
	/**
	 * Assume 1..1000 is the universal set
	 * @return 	Returns The Compliment Integer Set of The Reference Set.
	 */
	public int[] getComplement() {
		IntSet result;
		int length = 1000-this.size();
		int [] array = new int[length];
		int indexCompSet = 0;
		for(int index = 1; index <= 1000; index++) {
			if(!this.isMember(index)) {
				array[indexCompSet] = index;
				indexCompSet++;
			}
		}		
		result = new IntSet(array);
		return result.setArray;
	}
	
	
	/**
	 * 
	 * @param set1		An IntSet type Data type, The Set we want to check 
	 * whether it is subset or not.
	 * @return			True if set1 is the SubSet of the Set from 
	 * which method is called, Otherwise false. 
	 */
	public boolean isSubSet(IntSet set1) {
		boolean subSet = true;
		for(int index=0; index < set1.size(); index++) {
			if(!isMember(set1.setArray[index])) {
				subSet = false;
				break;
			}			
		}
		return subSet;
	}
}
