package EmployeesLinledList;

public class Node {

	public Employee employee;
	public Node next;

	public Node(Employee employee) {
		this.employee = employee;
		this.next = null;
	}
}