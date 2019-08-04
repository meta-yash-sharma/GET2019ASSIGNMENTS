package Employee;

import java.util.*;

public class EmployeMethods {
	
	private List<Employee> employeeList = new ArrayList<Employee>();
	private Set<Integer> employIdList = new HashSet<Integer>();
	
	
	public boolean addEmployee(int id, String name, String adress){
		
		boolean employEnter = false;
		
		if(!employIdList.contains(id)){
			Employee emp = new Employee(id, name, adress);
			employeeList.add(emp);
			employEnter = true;			
		}		
		return employEnter;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	
	public List<Employee> SortByNauralOrder() {		
		List<Employee> sortByNauralorder = employeeList;
		Collections.sort(sortByNauralorder);
		return sortByNauralorder;		
	}
	
	public List<Employee> SortByName(){		
		List<Employee> sortByName = employeeList;
		Collections.sort(sortByName , new Employee());		
		return sortByName;		
	}	
}
