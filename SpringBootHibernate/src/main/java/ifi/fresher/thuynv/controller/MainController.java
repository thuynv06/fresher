package ifi.fresher.thuynv.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ifi.fresher.thuynv.entities.Course;
import ifi.fresher.thuynv.service.CourseService;
import ifi.fresher.thuynv.service.StudentService;

@Controller
@RequestMapping(value = { "/" })
public class MainController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private CourseService courseService;

	@RequestMapping(value = { "/" })
	public String index(Model model) {
		model.addAttribute("listCourse", courseService.findAll());
		model.addAttribute("listStudent", studentService.findAll());
		return "index";
	}

	// lay danh sach khoa hoc
	@RequestMapping(value = { "/student-course/{id}" })
	public String getListStudent(@PathVariable int id, Model model) {
		model.addAttribute("student", studentService.findById(id));
		model.addAttribute("listC", studentService.getlistCourse(id));
		model.addAttribute("listCourse", courseService.findAll());
		return "student/student_course";
	}
	// damh ky khoa hoc
	@RequestMapping(value = "/addCourse/{id}", method = RequestMethod.POST)
	public String addCourse(@PathVariable int id, @RequestParam("listC[]") int[] listC, Model model) {
		List<Course> lc=new ArrayList<Course>();
		lc= studentService.getlistCourse(id);
		for (int i = 0; i < listC.length; i++) {
		//	System.out.println(listC[i]);
			lc.add(courseService.findById(listC[i]));
		}
		studentService.addCourse(id,lc);	
		return "redirect:/student-course/"+id;
	}
	@RequestMapping(value = { "/courseRemove/{id}" })
	public String removeCourse(@PathVariable int id, Model model) {
		
		return "redirect:/student-course/"+id;
	}
	
}
