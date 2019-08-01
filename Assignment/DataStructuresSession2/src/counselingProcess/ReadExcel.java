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

	private static String inputFile;
	public static List<String> parameter = new ArrayList<String>();
	//List<Program> pList = new ArrayList<Program>();
	private static Queue<Student> studentQueue = new LinkedList<>();

	private static HashMap<String, Integer> programList = new HashMap<>();

	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}


	public void readStudentList(String n) throws IOException  {
		setInputFile(n);
		File inputWorkbook = new File(inputFile);
		Workbook workbook;
		Student s;

		try {
			workbook = Workbook.getWorkbook(new File(inputFile));
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
				/*
				System.out.print(s.getStudentName()+"  ");
				for(int index = 0; index < s.getPreference().size(); index++){
					System.out.print(s.getPreference().get(index)+"  ");
				}
				System.out.println();
				 */
			}
		} catch (BiffException e) {
			e.printStackTrace();
		}
	}




	public void readProgramList(String n) throws IOException  {
		setInputFile(n);
		File inputWorkbook = new File(inputFile);
		Workbook workbook2;
		Program p;
		try {
			workbook2 = Workbook.getWorkbook(new File(inputFile));
			Sheet sheet = workbook2.getSheet(0);

			for (int j = 0; j < sheet.getRows(); j++) {

				Cell cell1 = sheet.getCell(0, j);
				Cell cell2 = sheet.getCell(1,j);
				programList.put(cell1.getContents(), Integer.parseInt(cell2.getContents()));
				p = new Program(cell1.getContents(),cell2.getContents());
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
