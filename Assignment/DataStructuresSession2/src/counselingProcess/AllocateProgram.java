package counselingProcess;

import java.util.*;

public class AllocateProgram {


	private static List<Allocate> studentAllocate = new ArrayList<Allocate>();

	public void allocate(){
		while (ReadExcel.getStudentQueue().size() > 0){

			for(int index = 0 ; index < 5; index++ ){

				if (ReadExcel.getProgramList().get(ReadExcel.getStudentQueue().peek().getPreference().get(index)) > 0) {					
					studentAllocate.add(new Allocate(ReadExcel.getStudentQueue().peek().getStudentName(),ReadExcel.getStudentQueue().peek().getPreference().get(index)));
					ReadExcel.getProgramList().put(ReadExcel.getStudentQueue().peek().getPreference().get(index),ReadExcel.getProgramList().get(ReadExcel.getStudentQueue().peek().getPreference().get(index)) - 1 );
					break;
				}
			}
			System.out.println(ReadExcel.getStudentQueue().size() + ReadExcel.getStudentQueue().peek().getStudentName());
			ReadExcel.getStudentQueue().remove();
		}
	}

	public static List<Allocate> getStudentAllocate() {
		return studentAllocate;
	}
}
