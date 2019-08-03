package queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueueTestCase {

	ImplementQueue queue = null;
	@Before
	public void Initialize(){
	queue = new ImplementQueue(5);
	}

	@Test
	public void testEnQueue() {
	queue.enQueue(1);
	assertEquals(1,queue.size());

	queue.enQueue(2);
	assertEquals(2,queue.size());


	queue.enQueue(3);
	assertEquals(3,queue.size());

	}

	@Test
	public void testDeQueue(){

	assertEquals(Integer.MIN_VALUE, queue.deQueue());

	queue.enQueue(1);
	queue.enQueue(2);
	queue.enQueue(3);
	queue.enQueue(4);

	assertEquals(1, queue.deQueue());
	assertEquals(2, queue.deQueue());

	}

	@Test
	public void testIsEmpty() {
	assertEquals(true, queue.empty());

	queue.enQueue(1);
	assertEquals(false, queue.empty());

	}

	@Test
	public void testIsFull() {

	assertEquals(false, queue.full());

	queue.enQueue(1);
	queue.enQueue(2);
	queue.enQueue(3);
	queue.enQueue(4);

	assertEquals(false, queue.full());

	queue.enQueue(5);
	assertEquals(true, queue.full());

	}


	@Test
	public void testQueueSize() {

	assertEquals(0, queue.size());

	queue.enQueue(1);
	assertEquals(1, queue.size());

	queue.enQueue(1);
	assertEquals(2, queue.size());

	}

}
