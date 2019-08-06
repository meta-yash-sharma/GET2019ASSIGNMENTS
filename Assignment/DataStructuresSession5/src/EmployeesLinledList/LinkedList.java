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
	
	public Node sortedMerge(Node a, Node b){
		
		Node result = null;
		
		if(a == null)
			return b;
		if(b == null)
			return a;
		
		if(a.data.getSalary() > b.data.getSalary()){
			result = a;
			result.next = sortedMerge(a.next , b);
		}
		else if(a.data.getSalary() > b.data.getSalary()){
			result = b;
			result.next = sortedMerge(a , b.next);
		}
		else{
			
			if(a.data.getAge() >= b.data.getAge()){
				result = a;
				result.next = sortedMerge(a.next , b);
			}
			else if(a.data.getAge() < b.data.getAge()){
				result = b;
				result.next = sortedMerge(a , b.next);
			}
		}
		return result;
	}
	
	
	public Node mergeSort(Node h){
		
		if(h == null || h.next == null)
			return h;
		
		Node middle = getMiddle(h);
		Node nextOfMiddle = middle.next;
		
		middle.next = null;
		
		Node left = mergeSort(h);
		
		Node right = mergeSort(nextOfMiddle);
		
		Node sortedLinkedList = sortedMerge(left, right);
		
		return sortedLinkedList;		
	}
	
	public Node getMiddle(Node h){
		
		if(h == null)
			return h;
		
		Node fast = h.next;
		Node slow = h;
		
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
