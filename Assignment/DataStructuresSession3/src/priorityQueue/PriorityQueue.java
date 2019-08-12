package priorityQueue;

public class PriorityQueue {
	
	private Task[] queue;
	private int capacity,queueSize;
	
	public PriorityQueue(int capacity){
		
		this.capacity = capacity+1;
		queue = new Task[this.capacity];
		queueSize = 0;
		queue[0] = new Task("",Integer.MIN_VALUE); 
	}
	
	/**
	 *  Clear the Queue.
	 */
	public void clear(){
		queue = new Task[capacity];
		queueSize = 0;		
	}
	
	
	/**
	 * Check whether the queue is empty or not.
	 * @return		True if queue is empty else false.
	 */
	public boolean empty(){
		boolean isEmpty = false;
		if(this.queueSize == 0)
			isEmpty = true;
		return isEmpty;
	}
	
	
	/**
	 * Check whether the queue is full or not.
	 * @return		True if queue is full else false.
	 */
	public boolean full(){
		boolean isFull = false;
		if(this.queueSize == this.capacity-1)
			isFull = true;
		return isFull;
	}
	
	
	/**
	 * Give the Size of Queue.
	 * @return	An integer value, Telling us the size of Queue.
	 */
	public int size(){
		return this.queueSize;
	}
	
	
	/**
	 * Add Element into Queue.
	 * @param process	An String type variable, tell the process name.
	 * @param priority	An Integer type variable, the priority of the process in Queue.
	 */
	public void insert(String process, int priority){
		
		if(full())
		{
			System.out.println("Can't insert As Queue Full");
			return;			
		}
		
		Task t = new Task(process, priority);
		queue[++queueSize] = t;
		int pos = queueSize;
		while(pos != 1 && t.getPriority() > queue[pos/2].getPriority()){
			queue[pos] = queue[pos/2];
			pos = pos/2;
		}
		queue[pos] = t;	
	}
	
	
	/**
	 * Remove Element from the Queue.
	 * @return	An Task type variable, The Highest priority element is removed from the queue.
	 */
	public Task remove(){
		int parent,child;
		Task item, temp;
		
		if(empty()){			
			System.out.println("Queue is Empty hence the Task can't be removed.");
			return null; 
		}
		
		item = queue[1];
		temp = queue[queueSize--];
		
		parent = 1;
		child = 2;
		
		while(child <= queueSize){
			if(child < queueSize && queue[child].getPriority() < queue[child+1].getPriority())
				child++;
			if(temp.getPriority() >= queue[child].getPriority())
				break;
			
			queue[parent] = queue[child];
			parent = child;
			child = child*2;
		}
		queue[parent] = temp;
		return item;
	}	
}
