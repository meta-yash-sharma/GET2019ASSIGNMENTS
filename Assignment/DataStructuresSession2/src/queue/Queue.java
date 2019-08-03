package queue;

public interface Queue {
	
	/**
	 * Add the Element in the Queue.
	 * @param data	An Integer Variable, is added in the Queue.
	 */
	public void enQueue(int data);
	
	/**
	 * Delete the First most Element of The Queue.
	 *  @return		An Integer Value, The Element at first index.
	 */
	public int deQueue();
	
	/**
	 * Check whether the Queue is empty or not.
	 * @return	True if Queue is empty else false.
	 */
	public boolean empty();
	
	/**
	 * Check Whether the Queue is Full or not.
	 * @return	True if the Queue is Full else False.
	 */
	public boolean full();
	
	/**
	 * Give Us the Size of Queue That is being used..
	 * @return
	 */
	public int size();
	
	
}
