package EmployeesLinledList;



public class EmployeeLinkedList {
	
	
	private Node head = new Node(null);
	private Node last;
	private int size = 0;

	public EmployeeLinkedList() {
		this.last = null;
	}

	/**
	 * @param employee Type data type inserted in linkedList
	 */
	public void insertEmployee(Employee employee) {
		Node newNode = new Node(employee);
		// if list is empty
		if (last == null) {
			head.next = newNode;
			last = newNode;
		}
		// enter employee at last index
		else {
			last.next = newNode;
			last = newNode;
		}
		size++;
	}

	
	/**
	 * @param index of employee linked list
	 * @return employee on index
	 */
	private Employee get(int index) {
		//check index is valid or not
		if (index < size) {
			Node curr = head;
			for (int i = 0; i < index; i++)
				curr = curr.next;
			return curr.next.employee;
		} else
			throw new AssertionError("index out of bound");
	}

	
	/**
	 * sort employees by quick sort algorithm
	 */
	void quickSort() {
		sort(0, size - 1);
	}

	/**
	 * @param low index of employee list
	 * @param high index of employee list
	 */
	private void sort(int low, int high) {
		if (low < high) {
			int pi = partition(low, high);
			//recursive call
			sort(low, pi - 1);
			sort(pi + 1, high);
		}
	}

	/**
	 * @param low index of employee list
	 * @param high index of employee list
	 * @return
	 */
	private int partition(int low, int high) {
		
		Employee pivot = get(high);
		int index = (low - 1);
		
		for (int index2 = low; index2 < high; index2++) {
			//check any employee has salary greater than pivot
			if (get(index2).getSalary() >= pivot.getSalary()) {
				//if salary is same than compare age
				if(get(index2).getSalary() == pivot.getSalary() && get(index2).getAge() > pivot.getAge())
					continue;
				index++;
				//swap data of employees
				String name = get(index).getName();
				int age = get(index).getAge();
				int salary = get(index).getSalary();
				get(index).setData(get(index2).getName(), get(index2).getAge(), get(index2).getSalary());
				get(index2).setData(name, age, salary);
			}
		}
		
		// set pivot employee on his correct position
		String name = get(index + 1).getName();
		int age = get(index + 1).getAge();
		int salary = get(index + 1).getSalary();
		get(index + 1).setData(get(high).getName(), get(high).getAge(), get(high).getSalary());
		get(high).setData(name, age, salary);
		return index + 1;
	}

	/**
	 * return employee name list
	 */
	public String[] getEmplyeeList() {
		String[] employees = new String[size];
		Node curr = head.next;
		int i = 0;
		while (curr != null && i < size) {
			employees[i] = curr.employee.getName();
			curr = curr.next;
			i++;
		}
		return employees;
	}
}