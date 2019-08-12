package priorityQueue;

public class PriorityQueueDriver {

	public static void main(String[] args) {
		
		PriorityQueue pq = new PriorityQueue(7);
		
		System.out.println("IS Empty : "+pq.empty());
		
		pq.insert("proces1", 24);
		pq.insert("proces2", 6);
		pq.insert("proces3", 28);
		System.out.println(pq.size());
		pq.insert("proces4", 63);
		pq.insert("proces5", 5);
		pq.insert("proces6", 94);
		pq.insert("proces7", 94);
		
		System.out.println("IS Full : "+pq.full());
		
		System.out.println(pq.size());
			System.out.println("Job Removed : "+pq.remove());
			System.out.println("Job Removed : "+pq.remove());
			System.out.println("Job Removed : "+pq.remove());
			System.out.println("Job Removed : "+pq.remove());
			System.out.println("Job Removed : "+pq.remove());
			System.out.println("Job Removed : "+pq.remove());
			System.out.println("Job Removed : "+pq.remove());
			System.out.println("Job Removed : "+pq.remove());			
	}
}
