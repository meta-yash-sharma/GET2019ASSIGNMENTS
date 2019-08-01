package counselingProcess;

import java.util.*;

public class Student {

	private String studentName;
	private List<String> preference = new ArrayList<String>();

	public Student(List<String> parameter){
		studentName = parameter.get(0);
		for(int index = 1; index < parameter.size(); index++){
			preference.add(parameter.get(index));
		}
		System.out.print(studentName+" ");
		for(int i = 1; i< parameter.size();i++)
			System.out.print(preference.get(i-1)+" ");
		System.out.println();
	}

	public String getStudentName() {
		return studentName;
	}

	public List<String> getPreference() {
		return preference;
	}
}
