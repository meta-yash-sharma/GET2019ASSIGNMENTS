package Question2;

class ClassData {
	
	public static void main(String[] args) {
		ClassMarkSheet class1 = new ClassMarkSheet();
		float average,percentage;
		int max,min;
		class1.getData();
		average = class1.calculateAverageOfAllGrades();
		max = class1.maxOfAllGrade();
		min = class1.minOfAllGrade();
		percentage = class1.pecentageOfStudentPass();
		class1.display();
		System.out.println("Avg of All Student : "+average);
		System.out.println("Max Of all The Marks : "+max);
		System.out.println("Min of All The Marks : "+min);
		if(percentage != -1)
			System.out.println("Percentage Of Student Passed : "+percentage);
	}
}