package ifi.fresher.thuynv.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ifi.fresher.thuynv.entities.Student;
import ifi.fresher.thuynv.service.CourseService;
import ifi.fresher.thuynv.service.StudentService;

@RestController
class AngularController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/list")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Student> listStudent(){
		List<Student> listStu= studentService.findAll();
		
		for (Student s:listStu) {
			s.setCourse(null);
		}
		return listStu;
	}
	
	
	
}
