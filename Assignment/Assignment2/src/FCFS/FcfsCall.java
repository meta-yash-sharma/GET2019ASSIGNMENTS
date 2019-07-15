package FCFS;

import java.util.*;

public class FcfsCall {
	/** 
	 * This is the main Class which is Used To take Arrival time and Burst time seconds in 
	 * a two dimensional array as input.  For example:
	 * [0][10]
	 * [6][20]
	 * [60][10]
	 * [110][5] 
	 * @param args Unused. 
	 * @return Nothing. 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Scanner sc = new Scanner(System.in);		
		int numberOfProcess;
		System.out.println("Enter The number of Process : ");
		numberOfProcess = sc.nextInt();
		if(numberOfProcess > 0)
		{
			int timeData[][] = new int[numberOfProcess][2];
			JobScheduler obj1 = new JobScheduler();
			// Take Input from user of Arrival and Burst Time in Systematic order.
			System.out.println("Enter The Arrival time and Burst time in systematic order.");
			for(int i=0; i<numberOfProcess; i++)
			{
				System.out.println("Arrival Time of process "+(i+1)+" in seconds : ");
				timeData[i][0] = sc.nextInt();
				System.out.println("Burst Time of process "+(i+1)+" in seconds : ");
				timeData[i][1] = sc.nextInt();			
			}
			System.out.println("\n");
			System.out.println("Completion Time.");
			int completionTimeData [] = new int [numberOfProcess];
			// Calls completionTime() Method to find the completion Time For Different process given by user.
			completionTimeData = obj1.completionTime(timeData);
			for(int i=0; i<numberOfProcess; i++)
			{
				System.out.println("Process "+(i+1)+" in seconds : "+completionTimeData[i]);
			}
			System.out.println("\n");
			System.out.println("Turn Around Time.");
			int turnAroundTimeData [] = new int [numberOfProcess];
			// Calls turnAroundTime() Method to find the Turn Around Time For Different process given by user.
			turnAroundTimeData = obj1.turnAroundTime(timeData, completionTimeData);
			for(int i=0; i<numberOfProcess; i++)
			{
				System.out.println("Process "+(i+1)+" in seconds : "+turnAroundTimeData[i]);
			}
			System.out.println("\n");
			System.out.println("Waiting Time.");
			int waitingTimeData [] = new int [numberOfProcess];
			// Calls waitingTime() Method to find the Waiting Time For Different Process given by user.
			waitingTimeData = obj1.waitingTime(timeData, turnAroundTimeData);
			for(int i=0; i<numberOfProcess; i++)
			{
				System.out.println("Process "+(i+1)+" in seconds : "+waitingTimeData[i]);
			}
			System.out.println("\n");
			double avgWaitingTimeOfProcess = obj1.avgWatingTimeOfProces(waitingTimeData);
			System.out.println("Average Waiting Time of process in seconds : "+avgWaitingTimeOfProcess);
			System.out.println("\n");
			int maxWaitingTimeOfProcessInQueue = obj1.maxWaitingTimeOfProcess(waitingTimeData);
			System.out.println("Max Waiting Time of process in Queue in seconds : "+maxWaitingTimeOfProcessInQueue);			
		}
		else
			System.out.println("Invalid Output.");
		sc.close();
		
	}

}
