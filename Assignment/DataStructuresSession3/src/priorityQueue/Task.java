package priorityQueue;

public class Task {
	
	private String process;
	private int priority;
	
	public Task(String process, int priority){
		this.process = process;
		this.priority = priority;
	}

	public String getJob() {
		return process;
	}

	public int getPriority() {
		return priority;
	}
	
	public String toString(){
		return "Process Name : "+ process + " Priority : "+ priority;
	}
}
