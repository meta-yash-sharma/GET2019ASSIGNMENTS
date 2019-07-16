package Question2;

import java.util.*;

class ClassMarkSheet {
	private int passingGrade = 40;
	private int numberOfStudent;
	private float averageOfAllGrades=0;
	private int maxOfGrade;
	private int minOfGrade;
	private float percentageOfStudentPass;
	private int classOfStudent [];
	
	
	/*
	 * Compute The process of Getting Marks Of n Number of Student Of Class.
	 * The value Of n should be Positive and marks Should be Between 0 to 100.
	 * @return Store all the Marks in an array of length n.
	 */
	void getData() {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		do {
			System.out.println("Enter The Number Of Student in class : ");
			numberOfStudent = sc.nextInt();
			if(numberOfStudent > 0)
				flag = false;
			else
				System.out.println("Number Of Student Can't be Negative or zero.");
		}while(flag);
		classOfStudent = new int [numberOfStudent];
		for(int i=0; i<numberOfStudent; i++)
		{
			flag = true;
			do{
				System.out.println("Enter Mark Of Student "+(i+1)+" between 0 to 100 : ");
				classOfStudent[i] = sc.nextInt();
				if(classOfStudent[i] >= 0 && classOfStudent[i] <= 100)
					flag = false;
				else
					System.out.println("Number Of Student Can't be Negative or greater than 100.");
			}while(flag);
		}
		//System.out.println("Enter The Passing marks : ");
		//passingGrade = sc.nextInt();
		sc.close();		
	}
	
	
	/*
	 * Compute The process of Displaying The Average, Max & Min Marks and as well as
	 *  Percentage of Student Pass.
	 * @return Display the above Data for n Number of Student in Class.
	 */
	void display() {
		System.out.println("Average Of All Grades : "+averageOfAllGrades);
		System.out.println("Maximum Of All The Marks : "+maxOfGrade);
		System.out.println("Minum Of All The Marks : "+minOfGrade);
		System.out.println("Percentage Of Student Passed : "+percentageOfStudentPass);
	}
	
	
	/*
	 * Compute The process of Getting Average Marks Of n Number of Student Of Class.
	 * @param An array of Size n which Store the marks of Student between 0 to 100
	 * @return The Average of the Array of Size n.
	 */
	float calculateAverageOfAllGrades() {
		for(int i=0;i<numberOfStudent; i++)
		{
			averageOfAllGrades += classOfStudent[i];
		}
		averageOfAllGrades = averageOfAllGrades/numberOfStudent;
		return averageOfAllGrades;
	}
	
	
	/*
	 * Compute The process of Getting Maximum Marks Of n Number of Student Of Class.
	 * @param An array of Size n which Store the marks of Student between 0 to 100
	 * @return The Maximum from marks all the student present in array of size n.
	 */
	int maxOfAllGrade() {
		maxOfGrade = classOfStudent[0];
		for(int i=1;i<numberOfStudent; i++)
		{
			if(classOfStudent[i] > maxOfGrade)
				maxOfGrade = classOfStudent[i] ;
		}
		return maxOfGrade;
	}
	
	
	/*
	 * Compute The process of Getting Minimum Marks Of n Number of Student Of Class.
	 * @param An array of Size n which Store the marks of Student between 0 to 100
	 * @return The Minimum marks from all the student marks present in the array.
	 */
	int minOfAllGrade() {
		minOfGrade = classOfStudent[0];
		for(int i=1;i<numberOfStudent; i++)
		{
			if(classOfStudent[i] < minOfGrade)
				minOfGrade = classOfStudent[i] ;
		}
		return minOfGrade;
	}
	
	
	/*
	 * Compute The process of Getting Percentage Of Student Passed.
	 * @param An array of Size n which Store the marks of Student between 0 to 100.
	 * @return The Percentage of Student passed i.e. number of Student greater than passing marks.
	 */
	float pecentageOfStudentPass() {
		int count=0;
		for(int i=0;i<numberOfStudent; i++)
		{
			if(classOfStudent[i] > passingGrade)
				count++;
		}
		try{
			percentageOfStudentPass = (count*100)/numberOfStudent;
			return percentageOfStudentPass;
		}
		catch(ArithmeticException e){
			System.out.println("Percentage can't be known due to error");			
		}
		return -1;
		
	}
	
}