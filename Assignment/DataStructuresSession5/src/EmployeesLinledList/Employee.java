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
	
	@Override
    public boolean equals(Object obj) 
    { 
          
    // if both the object references are  
    // referring to the same object. 
    if(this == obj) 
            return true; 
          
        // it checks if the argument is of the  
        // type Employee by comparing the classes  
        // of the passed argument and this object.
        if(obj == null || obj.getClass()!= this.getClass()) 
            return false; 
          
        // type casting of the argument.  
        Employee emp = (Employee) obj; 
          
        // comparing the state of argument with  
        // the state of 'this' Object. 
        return (emp.employeeId == this.employeeId && emp.age == this.age && emp.salary == this.salary); 
    }
	
	
	@Override
	public int hashCode() 
	{ 
		// We are returning the Employee_employeeId  
		// as a hashcode value. 
		// we can also return some  
		// other calculated value or may 
		// be memory address of the  
		// Object on which it is invoked.  
		// it depends on how you implement  
		// hashCode() method. 
		return this.employeeId;
	}
}
