package ifi.fresher.thuynv.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ifi.fresher.thuynv.entities.Course;
import ifi.fresher.thuynv.entities.Student;
import ifi.fresher.thuynv.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private SessionFactory sessionFactory;


	@RequestMapping(value = {"/student-list" })
	public String listStudent(Model model) {
		model.addAttribute("listStudent", studentService.findAll());
		return "student/student-list";
	}

	@RequestMapping(value = { "/student-save" })
	public String insertStudent(Model model) {
		model.addAttribute("student", new Student());
		return "student/student-save";
	}

	@RequestMapping("/student-view/{id}")
	public String viewStudent(@PathVariable int id, Model model) {
		Student student = studentService.findById(id);
		model.addAttribute("student", student);
		return "student/student-view";
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
	@RequestMapping(value = {"/student-course/{id}" })
	public String studentCourse(@ModelAttribute("Student") Student student,Model model) {
		  
		 	Session session = this.sessionFactory.getCurrentSession();
		 	session.beginTransaction();
	        Student s  = session.find(Student.class, 1);
	        System.out.println("Course name: " + s.getName());
	        s.getC().forEach(
	        		(c) ->System.out.println(c.getName())
	        		);
	        
	        session.close();
//		List<Course> c= studentService.studentCourse(student);
		model.addAttribute("cot",s.getC());
		return "student/student_course";
	}
	

}
