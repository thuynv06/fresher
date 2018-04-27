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
@RequestMapping(value="/courses")
class CourseController {
	@Autowired
	private CourseService courseService;
	@Autowired
	private StudentService studentService;
	@RequestMapping(method = RequestMethod.GET)
	public List<Course> findAll(){
		List<Course> listC= courseService.findAll();
		return listC;
	}
	@RequestMapping(value = "/{idCourse}", method = RequestMethod.GET)
	public Course getCourse(@PathVariable("idCourse") int id) {
		return courseService.findById(id);
	}
	@RequestMapping(method = RequestMethod.POST)
	public void saveCourse(@RequestBody Course course) {
		courseService.save(course);
	}
	@RequestMapping(value = "/{idCourse}", method = RequestMethod.DELETE)
	public boolean deleteCourse(@PathVariable int idCourse) {
		Course c= courseService.findById(idCourse);
		if (c != null) {
			courseService.delete(idCourse);
			return true;
		} else  {
			return false;
		}
	}
	@RequestMapping(method = RequestMethod.PUT)
	public void updateCourse(@RequestBody Course course) {
		courseService.update(course);
	}
	@RequestMapping(value = { "/student-course/{id}" },method = RequestMethod.GET)
	public List<Course> getStudentCourse(@PathVariable int id) { 
		List<Course> listC = studentService.getlistCourse(id);
		return listC;
	}
}