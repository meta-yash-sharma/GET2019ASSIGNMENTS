package counselingProcess;

import java.util.*;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;


public class ReadExcel {

	public static List<String> parameter = new ArrayList<String>();
	private static Queue<Student> studentQueue = new LinkedList<>();

	private static HashMap<String, Integer> programList = new HashMap<>();
	

	public void readStudentList(String inputFile) throws IOException  {
		File inputWorkbook = new File(inputFile);
		Workbook workbook;
		Student s;

		try {
			workbook = Workbook.getWorkbook(inputWorkbook);
			Sheet sheet = workbook.getSheet(0);
			for (int j = 0; j < sheet.getRows(); j++) {				
				for (int i = 0; i < sheet.getColumns(); i++) {
					Cell cell = sheet.getCell(i, j);
					CellType type = cell.getType();
					parameter.add(cell.getContents());
				}
				s = new Student(parameter);
				studentQueue.add(s);
				parameter.clear();
			}
		} catch (BiffException e) {
			e.printStackTrace();
		}
	}




	public void readProgramList(String inputFile) throws IOException  {
		
		File inputWorkbook = new File(inputFile);
		Workbook workbook2;
		try {
			workbook2 = Workbook.getWorkbook(inputWorkbook);
			Sheet sheet = workbook2.getSheet(0);

			for (int j = 0; j < sheet.getRows(); j++) {

				Cell cell1 = sheet.getCell(0, j);
				Cell cell2 = sheet.getCell(1,j);
				programList.put(cell1.getContents(), Integer.parseInt(cell2.getContents()));
				
			}			
		} catch (BiffException e) {
			e.printStackTrace();
		}
	}


	public static Queue<Student> getStudentQueue() {
		return studentQueue;
	}


	public static HashMap<String, Integer> getProgramList() {
		return programList;
	}
	
}
