package com.metacube.EAD_Session_13.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.metacube.EAD_Session_13.model.Student;




@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
	
	
	 /** No need to define findAll() here, because
     *  inherited from JpaRepository with many other basic JPA operations.**/
    //public List<Student> findAll();

    /** spring-jpa-data understands this method name,
     *  because it supports the resolution of specific keywords inside method names. **/
	
	public List<Student> findByfirstNameContainingIgnoreCase(String searchString);
	
	
	/** We can define a JPA query.**/
    @Query("select s from Student s where s.firstName = :firstName")
    public List<Student> findByNameIs(@Param("firstName") String name);

}
