package linkListMethods;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
	
	
	LinkedList list;
	@Before
	public void LinkedListCreate () {
		list = new LinkedList();
	}
	
	
	@Test
	public void rotateSubListTest() {
		
		LinkedList expected = new LinkedList(); 
		
		list.insert(2); list.insert(3); list.insert(4); list.insert(5); list.insert(6); list.insert(7);
		
		expected.insert(2); expected.insert(5); expected.insert(6); expected.insert(3); expected.insert(4); 
		expected.insert(7);
		
		list.rotateSubList(2, 5, 2);
		
		for(int index = 0; index < list.size(); index++){
			assertThat(list.get(index),is(expected.get(index)));			
		}		
	}	
	
	
	
	@Test 
	public void loopDetectedTest() {
		
		list.insert(2); list.insert(3); list.insert(4); list.insert(5); list.insert(6); list.insert(7);
		
		list.head.next.next.next.next.next.next = list.head.next.next;
		
		assertTrue(list.loopDetect());
	}
	
	@Test 
	public void loopDetectedTest2() {
		
		list.insert(2); list.insert(3); list.insert(4); list.insert(5); list.insert(6); list.insert(7);		
		assertFalse(list.loopDetect());
	}
}
