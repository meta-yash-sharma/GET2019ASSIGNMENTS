package FCFS;
/** 
 * This is the JobScheduler Class implements Interface TimeInterface hence define 3 Methods
 * Such As completionTime() to find Completion Time of the given Process and turnAroundTime() which
 * gives us Turn Around Time of the Given Process and Lastly waitingTime() which give us Waiting 
 * Time of given Process. 
 */
public class JobScheduler implements TimeInterface {
	/*
	 * Compute The process of Converting Arrival time And Burst Time data into Completion Time Of
	 * a given Process.
	 * @param Pass the 2-D Array in which Arrival time And Burst Time data is Stored.
	 * @return Return An 1-D Array in Which Completion Time of the Corresponding Process are Stored.
	 */
	public int[] completionTime (int [][] dataOnTime)
	{
		int completionTimeData [] = new int [dataOnTime.length];
		if(dataOnTime[0][0] == 0)
		{
			completionTimeData[0] = dataOnTime[0][1];			
		}
		else
		{
			completionTimeData[0] = dataOnTime[0][1] + dataOnTime[0][0];
		}
		
		for(int i=1; i< dataOnTime.length;i++)
		{
			if(completionTimeData[i-1] > dataOnTime[i][0])
			{
				completionTimeData[i] = completionTimeData[i-1] + dataOnTime[i][1]; 
			}
			else
			{
				completionTimeData[i] = dataOnTime[i][0] + dataOnTime[i][1];
			}
		}
		return completionTimeData;
	}
	/*
	 * Compute The process of Converting Arrival time And Burst Time data into Turn Around Time Of
	 * a given Process.
	 * @param Pass the 2-D Array in which Arrival time And Burst Time data is Stored.
	 * @param Pass the 1-D Array in which Completion Time data is Stored.
	 * @return Return An 1-D Array in Which Turn Around Time of the Corresponding Process is Stored.
	 */
	public int[] turnAroundTime (int [][] dataOnTime, int [] completionTimeOfData)
	{
		int turnAroundTimeData [] = new int [dataOnTime.length];
		for(int i=0; i < dataOnTime.length; i++)
		{
			turnAroundTimeData [i] = completionTimeOfData[i] - dataOnTime[i][0];
		}
		
		return turnAroundTimeData;
	}
	/*
	 * Compute The process of Converting Arrival time And Burst Time data into Waiting Time Of
	 * a given Process.
	 * @param Pass the 2-D Array in which Arrival time And Burst Time data is Stored.
	 * * @param Pass the 1-D Array in which Turn Around Time data is Stored.
	 * @return Return An 1-D Array in Which Waiting Time of the Corresponding Process is Stored.
	 */
	public int[] waitingTime (int [][] dataOnTime, int [] turnAroundTimeOfData)
	{
		int waitingTimeData [] = new int [dataOnTime.length];
		for(int i=0; i < dataOnTime.length; i++)
		{
			waitingTimeData [i] = turnAroundTimeOfData[i] - dataOnTime[i][1];
		}		
		return waitingTimeData;
	}
	/*
	 * Find The Average waiting Time Of All The Process Performed by The System
	 * @param Pass the 1-D Array in which Waiting Time data is Stored.
	 * @return Send us Average of value of Array passed.
	 */
	public double avgWatingTimeOfProces(int [] waitingTimeData)
	{
		double avgOfWaitingTimeOfProcess = 0.0;
		for(int i=0; i< waitingTimeData.length; i++)
		{
			avgOfWaitingTimeOfProcess += waitingTimeData[i];
		}
		avgOfWaitingTimeOfProcess = avgOfWaitingTimeOfProcess/waitingTimeData.length;
		//System.out.println(avgOfWaitingTimeOfProcess);
		return avgOfWaitingTimeOfProcess; 
	}
	/*
	 * Find The Max Waiting Time Of All The Process Performed by The System.
	 * @param Pass the 1-D Array in which Waiting Time data is Stored.
	 * @return Send us Maximum value of the given Array.
	 */
	public int maxWaitingTimeOfProcess (int [] waitingTimeData)
	{
		int maxWaitingTime = waitingTimeData[0];
		for(int i=1; i< waitingTimeData.length; i++)
		{
			if(waitingTimeData[i] > maxWaitingTime)
				maxWaitingTime = waitingTimeData[i];
		}
		
		return maxWaitingTime;
		
	}
}
