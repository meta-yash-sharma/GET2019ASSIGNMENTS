package counselingProcess;

import java.util.List;

public class Program {

	private String programName;
	private int capacity;

	public Program(String name, String capacity){
		programName = name;
		this.capacity = Integer.parseInt(capacity);
		System.out.println(programName+"  "+this.capacity);
	}

	public int getCapacity() {
		return capacity;
	}

	/**
	public void setCapacity() {
		this.capacity = this.capacity-1;
	}
	 */

	public String getProgramName() {
		return programName;
	}
}
