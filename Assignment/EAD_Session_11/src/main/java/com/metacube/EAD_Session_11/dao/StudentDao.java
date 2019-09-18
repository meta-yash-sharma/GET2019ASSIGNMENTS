package com.metacube.EAD_Session_11.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.metacube.EAD_Session_11.model.Student;


@Transactional
@Component
public class StudentDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void addStudent(Student student){
		
		hibernateTemplate.save(student);
				
	}
	
	public List<Student> getAllStudent(){
		
		List<Student> studentList = new ArrayList<Student>();
		
		studentList = hibernateTemplate.loadAll(Student.class);
		
		return studentList;
	}
}
