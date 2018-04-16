package ifi.fresher.thuynv.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.log4j2.Log4J2LoggingSystem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ifi.fresher.thuynv.entities.Course;
import ifi.fresher.thuynv.entities.Student;
import ifi.fresher.thuynv.service.CourseService;
import ifi.fresher.thuynv.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private CourseService courseService;

	@RequestMapping(value = { "/student-list" })
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

	// lay danh sach khoa hoc
	@RequestMapping(value = { "/student-course/{id}" })
	public String getListStudent(@PathVariable int id, Model model) {
		model.addAttribute("student", studentService.findById(id));
		model.addAttribute("listC", studentService.getlistCourse(id));
		model.addAttribute("listCourse", courseService.findAll());
		return "student/student_course";
	}

	@RequestMapping(value = "/addCourse/{id}", method = RequestMethod.POST)
	public String action(@PathVariable int id, @RequestParam("listC[]") int[] listC, Model model) {
		// Student s = studentService.findById(id);
		// for (int i = 0; i < listC.length; i++) {// length is the property of array
		// System.out.println(listC[i]);
		// }
		List<Course> listCourse = new ArrayList<Course>();
		for (int i = 0; i < listC.length; i++) {
			 
			System.out.println(listC[i]);
			listCourse.add(courseService.findById(listC[i]));
		}
		studentService.addCourse(id, listCourse);

		model.addAttribute("student", studentService.findById(id));
		model.addAttribute("listC", studentService.getlistCourse(id));
		model.addAttribute("listCourse", courseService.findAll());
		return "student/student_course";

		// Transaction transaction = null;
		// try {
		// transaction = session.beginTransaction();
		//
		// Set<Course> courses = new HashSet<Course>();
		// courses.add(new Course("Maths"));
		// courses.add(new Course("Computer Science"));
		//
		// Student student1 = new Student("Eswar", courses);
		// Student student2 = new Student("Joe", courses);
		// session.save(student1);
		// session.save(student2);
		//
		// transaction.commit();
		// } catch (HibernateException e) {
		// transaction.rollback();
		// e.printStackTrace();
		// } finally {
		// session.close();
		// }

	}

}
