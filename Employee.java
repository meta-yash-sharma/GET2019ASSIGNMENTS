package Employee;

import java.util.Comparator;

public class Employee implements Comparable<Employee>, Comparator<Employee> {
	
	private int id;
	private String name;
	private String address;
	
	public Employee(){
		
	}
	
	public Employee(int id, String name, String address){
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public int compareTo(Employee arg) {
		return this.id - arg.getId();
	}

	@Override
	public int compare(Employee emp1, Employee emp2) {
		return  emp1.getName().compareTo(emp2.getName());
	}
		
	
}
