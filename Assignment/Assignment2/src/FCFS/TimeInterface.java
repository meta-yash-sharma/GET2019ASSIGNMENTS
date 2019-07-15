package FCFS;
/** 
 * This is the TimeInterface Interface which is used to Store 3 Method which will be pass on
 * to its implements so that they can define and used These basic methods used in All Time process
 * related Class.  
 */
public interface TimeInterface {
	int[] completionTime (int [][] dataOnTime);
	int[] turnAroundTime (int [][] dataOnTime, int [] completionTimeOfData);
	int[] waitingTime (int [][] dataOnTime, int [] turnAroundTimeOfData);
}