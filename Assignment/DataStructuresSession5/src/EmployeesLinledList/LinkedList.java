package EmployeesLinledList;

public class LinkedList {	
	
	/**
	 * Node of LinkedList Contains Data and Next Node Value.
	 */
	public static Node head = null;
	
	public class Node {
		public Employee data;
		public Node next;
		
		public Node (Employee  data){
			this.data = data;
		}
	}
	
	
	public static Node getHead() {
		return head;
	}

	/**
	 * Add an Node to Linked list.
	 * @param data	An Integer value, To be stored in data format in Node.
	 */
	public void push(Employee data){
		
		if(data == null){
			throw new AssertionError("invalid Employee Data.");
		}
		
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;	
	}
	
	public Node sortedMerge(Node node1, Node node2){
		
		if(node1 == null && node2 == null){
			throw new NullPointerException();
		}
		
		Node result = null;
		
		if(node1 == null)
			return node2;
		if(node2 == null)
			return node1;
		
		if(node1.data.getSalary() > node2.data.getSalary()){
			result = node1;
			result.next = sortedMerge(node1.next , node2);
		}
		else if(node1.data.getSalary() > node2.data.getSalary()){
			result = node2;
			result.next = sortedMerge(node1 , node2.next);
		}
		else{
			
			if(node1.data.getAge() >= node2.data.getAge()){
				result = node1;
				result.next = sortedMerge(node1.next , node2);
			}
			else if(node1.data.getAge() < node2.data.getAge()){
				result = node2;
				result.next = sortedMerge(node1 , node2.next);
			}
		}
		return result;
	}
	
	
	public Node mergeSort(Node node){
		
		if(node == null){
			throw new NullPointerException();
		}
		
		if(node.next == null)
			return node;
		
		Node middle = getMiddle(node);
		Node nextOfMiddle = middle.next;
		
		middle.next = null;
		
		Node left = mergeSort(node);
		
		Node right = mergeSort(nextOfMiddle);
		
		Node sortedLinkedList = sortedMerge(left, right);
		
		return sortedLinkedList;		
	}
	
	public Node getMiddle(Node node){
		
		if(node == null)
			throw new NullPointerException();
		
		Node fast = node.next;
		Node slow = node;
		
		while(fast != null){
			fast = fast.next;
			if(fast != null){
				slow = slow.next;
				fast = fast.next;
			}
		}
		return slow;
	}
	
	public void display(){
		
		Node newNode = head;		
		while(newNode != null){
			System.out.println(newNode.data.toString());
			newNode = newNode.next;
		}		
	}
	
	@Override
    public boolean equals(Object obj) 
    { 
          
    // if both the object references are  
    // referring to the same object. 
    if(this == obj) 
            return true; 
          
        // it checks if the argument is of the  
        // type Employee by comparing the classes  
        // of the passed argument and this object.
        if(obj == null || obj.getClass()!= this.getClass()) 
            return false; 
          
        // type casting of the argument.  
        LinkedList list = (LinkedList) obj; 
          
        // comparing the state of argument with  
        // the state of 'this' Object. 
        return (list.head == this.head); 
    }
	
	@Override
	public int hashCode() 
    	{ 
          
        // We are returning the Employee_employeeId  
        // as a hashcode value. 
        // we can also return some  
        // other calculated value or may 
        // be memory address of the  
        // Object on which it is invoked.  
        // it depends on how you implement  
        // hashCode() method. 
     		return this.head.data.getEmployeeId();
    	}
	
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
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
		
		 list.head = list.mergeSort(list.head);
		 list.display();
	}

}
