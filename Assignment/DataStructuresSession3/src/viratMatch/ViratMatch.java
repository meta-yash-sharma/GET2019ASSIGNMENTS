package viratMatch;

import java.util.*;

public class ViratMatch {

	public static void main(String[] args) {
		
		List<String> bowlingOrder = new ArrayList<String>();
		
		int numberOfBowlers = 10;
		Heap heap = new Heap(numberOfBowlers);
		
		heap.insert("b1", 2);
		heap.insert("b2", 4);
		heap.insert("b3", 1);
		heap.insert("b4", 3);
		heap.insert("b5", 6);
		heap.insert("b6", 6);
		
		BowlingOrder b1 = new BowlingOrder(10,heap);
		 bowlingOrder = b1.BowlingOrderList();

	}

}
