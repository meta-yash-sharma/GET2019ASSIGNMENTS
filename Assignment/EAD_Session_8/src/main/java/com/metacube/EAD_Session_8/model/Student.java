package com.metacube.EAD_Session_8.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Student {
	
	
	@Size(min = 2 , max = 20, message = "{firstName}")
	@Pattern(regexp = "[A-Z a-z]*")
	private String firstName;
	
	@Size(min = 2, max = 20,message = "{lastName}")
	@Pattern(regexp = "[A-Z a-z]*")
	private String lastName;
	
	@Size(min = 2, max = 20,message = "{fatherName}")
	@Pattern(regexp = "[A-Z a-z]*")
	private String fatherName;
	
	@NotBlank(message = "{blankEmail}")
	private String email;
	
	@NotNull(message = "{blankStd}")
	@Min(1)
	@Max(12)
	private int classNo;
	
	@NotNull(message = "{blankAge}")
	@Min(5)
	@Max(20)
	private int age;
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public int getClassNo() {
		return classNo;
	}

	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "studentPojo [firstName=" + firstName + ", lastName=" + lastName
				+ ", fatherName=" + fatherName + ", classNo=" + classNo
				+ ", age=" + age + "]";
	}

}
