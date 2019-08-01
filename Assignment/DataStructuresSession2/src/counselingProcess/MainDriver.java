package counselingProcess;

import java.io.IOException;

public class MainDriver {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ReadExcel r1 = new ReadExcel();

		r1.readStudentList("C:\\Users\\Yash\\Downloads\\StudentList.xls");

		r1.readProgramList("C:\\Users\\Yash\\Downloads\\ProgramList.xls");

		AllocateProgram a1 = new AllocateProgram();

		a1.allocate();

		for(int i = 0; i < a1.getStudentAllocate().size(); i++){
			System.out.println(a1.getStudentAllocate().get(i).getStudentName()+"  "+a1.getStudentAllocate().get(i).getBranch());
		}


		WriteExcel w1 = new WriteExcel();

		w1.writeFile();
	}

}
