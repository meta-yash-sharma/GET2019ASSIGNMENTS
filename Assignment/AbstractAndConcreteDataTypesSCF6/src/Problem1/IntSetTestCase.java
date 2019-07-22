package Problem1;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntSetTestCase {

	@Test
	public void IntSet1 () {
		int [] array1 = {1,2,4,7,10};
		int [] array2 = {1,2,3,4,5,7,10,12,34,45};
		
		IntSet set1 = new IntSet(array1);
		IntSet set2 = new IntSet(array2);
		
		int length = 1000-set1.size();
		int [] complement = new int[length];
		int index=0;
		for(int i=1; i<= 1000; i++){
			if(!set1.isMember(i)){
				complement[index] = i;
				index++;
			}				
		}
		
		/*
		for(int index1 = 0; index1 < complement.length; index1++)
			System.out.println(complement[index1]+"  ");
		*/	
		
		assertTrue(set1.isMember(7));
		assertFalse(set2.isMember(32));
		
		assertEquals(5,set1.size());
		assertNotEquals(13,set2.size());
		
		int [] array = {1,2,4,7,10,3,5,12,34,45};
		assertArrayEquals(array,set1.union(set1, set2));
		
		assertTrue(set2.isSubSet(set1));
		
		assertArrayEquals(complement,set1.getComplement());
		
		
		
		
		
	}

}
