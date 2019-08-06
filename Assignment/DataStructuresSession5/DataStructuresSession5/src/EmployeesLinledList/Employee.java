package EmployeesLinledList;

public class Employee {
	
	private int employeeId;
	private double salary;
	private int age;
	
	public Employee(int id, double salary, int age){
		this.employeeId = id;
		this.salary = salary;
		this.age = age;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public double getSalary() {
		return salary;
	}

	public int getAge() {
		return age;
	}
	
	public String toString(){
		
		return "Employee id: "+employeeId+ " Employee Salary : "+salary+" Employee Age : "+age;
	}
}
