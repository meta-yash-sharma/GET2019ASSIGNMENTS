package viratMatch;

import java.util.*;

public class BowlingOrder {	
	
	public int ballToPlay;
	public Heap heap;
	public List<String> bowlingOrder;
	
	public BowlingOrder(int ballToPlay, Heap h){
		this.ballToPlay = ballToPlay;
		this.heap = h;
		
	}
	
	
	/**
	 * Send us the list of bowling order to be given to virat as to make him score less run
	 * @return		The string type list, the bowler name with respect to their bowling order.
	 */
	public List<String> BowlingOrderList(){
		bowlingOrder = new ArrayList<String>();
		for(int index = 0; index < ballToPlay; index++){
			
			Bowler temp = heap.remove();
			heap.insert(temp.getBowlerName(), temp.getBallLeft()-1);
			bowlingOrder.add(temp.getBowlerName());
			System.out.println("Bowler Name : "+temp.getBowlerName()+" \tBalls Left of Bowler : "+(temp.getBallLeft()-1));			
			System.out.println("Number of Balls left for Virat to play :"+(ballToPlay-(index+1)));
			System.out.println();
		}
		return bowlingOrder;
	}
}
