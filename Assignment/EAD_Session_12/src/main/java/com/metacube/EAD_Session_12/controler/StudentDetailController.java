package com.metacube.EAD_Session_12.controler;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.EAD_Session_12.model.Student;
import com.metacube.EAD_Session_12.service.ServiceClass;





@Controller
public class StudentDetailController {
	
	List<Student> studentList = new ArrayList<>();
	
	@Autowired
	private ServiceClass serviceObj;
	
	@Value("${welcome.message}")
	private String welcomeMessage;
	
	 @GetMapping("/home")
	 public String home(Model model){
	 model.addAttribute("welcomeMessage",welcomeMessage);
	 return "home";
	 }
	
	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		model.addAttribute("student", new Student());
		return "addStudent";
	}

	@PostMapping("/addStudent")
	public String studentAdded(@Validated Student student, BindingResult result) {

		if (result.hasErrors()) {
			return "addStudent";
		} else {
			
			serviceObj.add(student);
			return "redirect:/home";
		}

	}
	
	
	@GetMapping("/showStudent")
	public String showStudent(Model model) {
		
		studentList = serviceObj.findAll();
		model.addAttribute("studentList", studentList);
		
		return "showStudent";
	}
	
}
