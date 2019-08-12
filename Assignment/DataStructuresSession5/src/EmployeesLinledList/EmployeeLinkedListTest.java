package EmployeesLinledList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class EmployeeLinkedListTest {
	
	
	LinkedList list;
	
	@Before
	public void Initialize(){
		
		list = new LinkedList();
		
		Employee e1 = new Employee(1, 2000.0, 24);
		Employee e2 = new Employee(2, 8000.0, 24);
		Employee e3 = new Employee(3, 6000.0, 28);
		Employee e4 = new Employee(4, 10000.0, 34);
		Employee e5 = new Employee(5, 2000.0, 22);
		
		list.push(e1);
		list.push(e2);
		list.push(e3);
		list.push(e4);
		list.push(e5);
		
	}	

	@Test
	public void EmployeeLinkedListSortingTest() {
		LinkedList list2 = new LinkedList();
		Employee e1 = new Employee(1, 2000.0, 24);
		Employee e2 = new Employee(2, 8000.0, 24);
		Employee e3 = new Employee(3, 6000.0, 28);
		Employee e4 = new Employee(4, 10000.0, 34);
		Employee e5 = new Employee(5, 2000.0, 22);
		list2.push(e5);
		list2.push(e1);
		list2.push(e2);
		list2.push(e3);
		list2.push(e4);
		
		
		assertEquals(list2.head,list.mergeSort(list.head));
	}

}
