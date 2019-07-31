package linkListMethods;


public class LinkedList {
	
	/**
	 * Node of LinkedList Contains Data and Next Node Value.
	 */
	public static Node head;
	
	public class Node {
		public int data;
		public Node next;
		
		public Node (int data){
			this.data = data;
		}
	}
	
	
	/**
	 * Add an Node to Linked list.
	 * @param data	An Integer value, To be stored in data format in Node.
	 */
	public void insert(int data){
		
		Node newNode = new Node(data);
		newNode.next = null;
		
		if(head == null) {
			head  = newNode;
		}
		else {
			
			Node last = head;
			while(last.next != null){
				last = last.next;
			}
			last.next = newNode;
		}
	}
	
	
	/**
	 * Display the LinkedList.
	 */
	public void printLinkedList() {
		Node currentNode = head;
		
		while(currentNode != null) {
			if(currentNode.next != null){
				System.out.print(currentNode.data+"-> ");
			}
			else {
				System.out.print(currentNode.data);
			}			
			currentNode = currentNode.next;
		}
		System.out.println();
	}
	
	
	/**
	 * Detect whether their is a Loop in Linked List or not.
	 * @return		True if loop is detected in linked List else False. 
	 */
	public boolean loopDetect() {
		Node node1 = head, node2 = head;
		boolean isLoop = false;
		
		while(node1 != null && node2 != null && node2.next != null){
			node1 = node1.next;
			node2 = node2.next.next;
			
			if(node1 == node2){
				isLoop = true;
				break;
			}							
		}
		return isLoop;
	}
	
	
	/**
	 * Method to rotate sub list in clockwise direction by the number of steps (N) given as input. 
	 * @param left	An integer, positive value, the Left position in list from where subList Start.
	 * @param right	An integer, positive value, the Right position in list where subList End.
	 * @param n		number of steps to rotate sub list in clockwise direction.
	 */
	public void rotateSubList(int left, int right, int n) {

		if(n > (right - left + 1)) {
			n = n%(right - left + 1);
		}
		
		if(n == 0 || n == (right - left + 1)){
			return;
		}
		
		Node leftNode = null;
		if(left == 1){
			leftNode = head;
		}
		
		Node prevNode = null;
		Node endNode = null;
		Node current = head;
		int count = 0;		
		while(current != null){
			count++;
			
			if(count == left-1){
				prevNode = current;
				leftNode = current.next;				
			}
			
			if(count == right-n){
				if(left == 1){
					endNode = current;
					head = current.next;
					}
				else {
					endNode = current;
					prevNode.next = current.next;
				}
			}
			
			if(count == right) {
				Node rightNode = current;
				endNode.next = current.next;
				rightNode.next = leftNode;				
				return;
			}
			current = current.next;
		}		
	}
	
	
	/**
	 * Get the node of given index of linked list.
	 * @param index		An integer value, the index of which node you want to get of linked list.
	 * @return		An Node type Object.
	 */
	public Node get(int index){
		int count = 0;
		Node node = head;
		while(count < index){
			node = node.next;
			count++;
		}
		return node;
	}
	
	
	/**
	 * Give us the size of linked list.
	 * @return	An integer value, Return the size of Linked List.
	 */
	public int size(){
		int count = 0;
		Node node = head;
		while(node != null){
			node = node.next;
			count++;
		}
		return count;
	}
	
	/**
	public static void main(String [] args) {
		
		LinkedList list = new LinkedList();
		
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		
		System.out.println(list.loopDetect());
		
		list.printLinkedList();
		
		list.rotateSubList(2, 5, 2);
		System.out.println(list.loopDetect());
		list.printLinkedList();		
	}
	*/
}
