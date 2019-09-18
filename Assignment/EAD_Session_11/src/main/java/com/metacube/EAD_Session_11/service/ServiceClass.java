package com.metacube.EAD_Session_11.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.EAD_Session_11.dao.StudentDao;
import com.metacube.EAD_Session_11.model.Student;

@Service
public class ServiceClass {
	
	@Autowired
	private StudentDao obj; 
	
	public void addStudent(Student student){
		
		 obj.addStudent(student);
		 
	}
	
	public List<Student> getAllStudent(){
		
		return obj.getAllStudent();
	}
	
}
