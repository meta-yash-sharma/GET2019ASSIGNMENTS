package stack;


public class Stack implements StackInterface {

	public static Node Top;

	public class Node {
		public String data;
		public Node next;

		public Node (String data){
			this.data = data;
			this.next = null;
		}
	}
	@Override
	public void push(String data){
		
		Node newNode = new Node(data);
		
		if(Top == null) {
			Top  = newNode;
		}
		
		else {
			newNode.next = Top;
			Top = newNode;			
		}
		//System.out.println(Top.data);
	}
	
	@Override
	public Node pop(){
		
		Node newNode = Top;
		//System.out.println(Top.data);
		Top = Top.next;
		//System.out.println(Top.data);
		return newNode;
	}
	
	@Override
	public Node top(){
		return Top;
	}
	
	public boolean empty(){
		boolean isEmpty = false;
		if(Top == null)
			isEmpty = true;
		return isEmpty;
	}
}
