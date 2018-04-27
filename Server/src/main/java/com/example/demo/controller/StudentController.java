package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Course;
import com.example.demo.entities.Student;
import com.example.demo.service.CourseService;
import com.example.demo.service.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/student")
class StudentController {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Student> findAll(){
		List<Student> listStu= studentService.findAll();
		return listStu;
	}
	@RequestMapping(value = "/{idStudent}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable("idStudent") int id) {
		return studentService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void saveStudent(@RequestBody Student student) {
		studentService.save(student);
	}
	@RequestMapping(value = "/{idStudent}", method = RequestMethod.DELETE)
	public boolean deleteUser(@PathVariable int idStudent) {
		Student s= studentService.findById(idStudent);
		if (s != null) {
			studentService.delete(idStudent);
			return true;
		} else  {
			return false;
		}
	}
	@RequestMapping(method = RequestMethod.PUT)
	public void updateStudent(@RequestBody Student student) {
		studentService.update(student);
	}
	@RequestMapping(value = { "/course-student/{id}" },method = RequestMethod.GET)
	public List<Student> getStudentCourse(@PathVariable int id) { 
		List<Student> listS = courseService.getListStudent(id);
		return listS;
	}
	
}
