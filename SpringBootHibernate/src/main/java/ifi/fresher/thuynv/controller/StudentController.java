package ifi.fresher.thuynv.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.log4j2.Log4J2LoggingSystem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ifi.fresher.thuynv.entities.Course;
import ifi.fresher.thuynv.entities.Student;
import ifi.fresher.thuynv.service.CourseService;
import ifi.fresher.thuynv.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private CourseService courseService;

	@GetMapping(value = { "/student-list" })
	@CrossOrigin(origins="http://localhost:4200")
	public List<Student> listStudent() {
//		model.addAttribute("listStudent", studentService.findAll());
//		return "student/student-list";
		return studentService.findAll();
	}

	@RequestMapping(value = { "/student-save" })
	public String insertStudent(Model model) {
		model.addAttribute("student", new Student());
		return "student/student-save";
	}

	@RequestMapping(value = { "/student/{id}" })
	@CrossOrigin(origins="http://localhost:4200")
	public Student viewStuden(@PathVariable int id ) {
//		Student student = studentService.findById(id);
//		model.addAttribute("student", student);
		return studentService.findById(id);
	}

	@RequestMapping("/student-update/{id}")
	public String updateStudent(@PathVariable int id, Model model) {
		Student student = studentService.findById(id);
		model.addAttribute("student", student);
		return "student/student-update";
	}

	@RequestMapping("/saveStudent")
	public String doSaveStudent(@ModelAttribute("Student") Student student, Model model) {
		studentService.save(student);
		model.addAttribute("listStudent", studentService.findAll());
		return "redirect:student-list";
	}

	@RequestMapping("/updateStudent")
	public String doUpdateStudent(@ModelAttribute("Student") Student student, Model model) {
		studentService.update(student);
		model.addAttribute("listStudent", studentService.findAll());
		return "redirect:student-list";
	}

	@RequestMapping("/studentDelete/{id}")
	public String doDeleteStudent(@PathVariable int id, Model model) {
		studentService.delete(id);
		model.addAttribute("listStudent", studentService.findAll());
		return "redirect:/student-list";
	}



}
