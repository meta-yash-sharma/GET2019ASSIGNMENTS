package queue;


public class ImplementQueue implements Queue {
	
	private int front,rear,capacity;
	private int [] queue;
	private int queueSize = 0;
	
	public ImplementQueue(int capacity){
		front = -1;
		rear = -1;
		this.capacity = capacity;
		queue = new int[this.capacity];
	}
	
	

	@Override
	public void enQueue(int data) {
		
		if(full()){
			System.out.println("Queue is full.");
			return;
		}
		else if(front == -1){
			front = 0;
			rear = 0;
			queue[rear] = data;
		}
		else if(rear == capacity-1 && front != 0){
			rear = 0;
			queue[rear] = data;
		}
		else {
			rear++;
			queue[rear] = data;
		}
		queueSize++;
	}

	@Override
	public int deQueue() {
		
		if(empty()){
			System.out.println("Queue is Empty.");
			return Integer.MIN_VALUE;
		}
		int item = queue[front];
		queue[front] = -1;
		
		if(front == rear){
			front = -1;
			rear = -1;
		}
		else if(front == capacity-1){
			front = 0;
		}
		else
			front++;
		
		queueSize--;
		
		return item;
	}

	@Override
	public boolean empty() {
		
		boolean isEmpty = false;
		
		if(front == -1){
			isEmpty = true;
		}
		return isEmpty;
	}

	@Override
	public boolean full() {
		
		boolean isFull= false;
		if((rear == capacity-1 && front == 0) || rear == (front-1)%(capacity-1)){
			isFull =  true;
		}
		return isFull;
	}
	
	
	@Override
	public int size() {
		return queueSize;
	}
	
	/**
	 * Display All the Element in the Queue in the Systematic order.
	 */
	public void display(){
		
		if(front == -1){
			System.out.println("Queue is Empty.");
		}
		if(rear >= front) {
			for(int index = front; index <= rear; index++){
				System.out.print(queue[index]+" ");
			}				
		}
		else {
			for(int index2 = front; index2 < capacity; index2++){
				System.out.print(queue[index2]+" ");
			}
			for(int index3 = 0; index3 < rear+1; index3++){
				System.out.print(queue[index3]+" ");
			}
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		
		ImplementQueue queue1 = new ImplementQueue(5);
		queue1.enQueue(1);
		queue1.enQueue(2);
		queue1.enQueue(3);
		queue1.enQueue(4);
		queue1.enQueue(5);
		
		queue1.display();
		queue1.enQueue(6);
		
		queue1.deQueue();
		queue1.enQueue(6);
		
		queue1.display();
		
		queue1.deQueue();
		queue1.deQueue();
		queue1.display();
		
		queue1.deQueue();
		queue1.deQueue();
		queue1.deQueue();
		queue1.deQueue();
	}

}
