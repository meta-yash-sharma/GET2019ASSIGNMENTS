package counselingProcess;

public class Allocate {

	private String studentName;
	private String branch;

	public Allocate(String name, String branch){
		this.studentName = name;
		this.branch = branch;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getBranch() {
		return branch;
	}
}
