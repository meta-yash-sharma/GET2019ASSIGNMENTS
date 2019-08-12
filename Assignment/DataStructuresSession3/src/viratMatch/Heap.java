package viratMatch;


public class Heap {
	
	private Bowler[] heap;
	private int capacity,heapSize;
	
	public Heap(int capacity){
		
		this.capacity = capacity+1;
		heap = new Bowler[this.capacity];
		heapSize = 0;
		heap[0] = new Bowler("",Integer.MIN_VALUE);
	}
	
	
	/**
	 *  Clear the Heap Array.
	 */
	public void clear(){
		heap = new Bowler[capacity];
		heapSize = 0;		
	}
	
	
	/**
	 * Check whether the Heap Array is empty or not.
	 * @return		True if Heap Array is empty else false.
	 */
	public boolean empty(){
		boolean isEmpty = false;
		if(this.heapSize == 0)
			isEmpty = true;
		return isEmpty;
	}
	
	
	/**
	 * Check whether the Heap Array is full or not.
	 * @return		True if queue is Heap Array else false.
	 */
	public boolean full(){
		boolean isFull = false;
		if(this.heapSize == this.capacity-1)
			isFull = true;
		return isFull;
	}
	
	
	/**
	 * Give the Size of Heap Array.
	 * @return	An integer value, Telling us the size of Heap Array.
	 */
	public int size(){
		return this.heapSize;
	}
	
	
	/**
	 * Add Element into Max Heap.
	 * @param bowlerName	An String type variable, tell the bowler Name.
	 * @param ballLeft	An Integer type variable, the remaining ball of 
	 * bowler with the help of which max heap is created.
	 */
	public void insert(String bowlerName, int ballLeft){
		
		if(full())
		{
			System.out.println("Can't insert As Queue Full");
			return;			
		}
		
		Bowler t = new Bowler(bowlerName, ballLeft);
		heap[++heapSize] = t;
		int pos = heapSize;
		while(pos != 1 && t.getBallLeft() > heap[pos/2].getBallLeft()){
			heap[pos] = heap[pos/2];
			pos = pos/2;
		}
		heap[pos] = t;		
	}
	
	
	/**
	 * Remove Element from the heap.
	 * @return	An Bowler type variable, The Bowler with Highest remaining balls 
	 * is removed from the queue.
	 */
	public Bowler remove(){
		int parent,child;
		Bowler item, temp;
		
		if(empty()){			
			System.out.println("Queue is Empty hence the Task can't be removed.");
			return null; 
		}
		
		item = heap[1];
		temp = heap[heapSize--];
		
		parent = 1;
		child = 2;
		
		while(child <= heapSize){
			if(child < heapSize && heap[child].getBallLeft() < heap[child+1].getBallLeft())
				child++;
			if(temp.getBallLeft() >= heap[child].getBallLeft())
				break;
			
			heap[parent] = heap[child];
			parent = child;
			child = child*2;
		}
		heap[parent] = temp;
		return item;
	}

}
