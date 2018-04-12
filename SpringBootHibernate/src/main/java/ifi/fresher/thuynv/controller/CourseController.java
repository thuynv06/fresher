package ifi.fresher.thuynv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ifi.fresher.thuynv.entities.Course;
import ifi.fresher.thuynv.service.CourseService;

@Controller
public class CourseController {
	@Autowired
	private CourseService courseService;

	@RequestMapping(value = { "course-list" })
	public String listCourse(Model model) {
		model.addAttribute("listCourse", courseService.findAll());
		return "course/course-list";
	}
	@RequestMapping(value = { "/course-save" })
	public String insertCourse(Model model) {
		model.addAttribute("course", new Course());
		return "/course/course-save";
	}

	@RequestMapping("/course-view/{id}")
	public String viewCourse(@PathVariable int id, Model model) {
		Course course = courseService.findById(id);
		model.addAttribute("course", course);
		return "course/course-view";
	}
	
	@RequestMapping("/course-update/{id}")
	public String updateCourse(@PathVariable int id, Model model) {
		Course course = courseService.findById(id);
		model.addAttribute("course", course);
		return "course/course-update";
	}

	@RequestMapping("/saveCourse")
	public String doSaveCourse(@ModelAttribute("Course") Course course, Model model) {
		courseService.save(course);
		model.addAttribute("listCourse", courseService.findAll());
		return "redirect:course-list";
	}

	@RequestMapping("/updateCourse")
	public String doUpdateCourse(@ModelAttribute("Course") Course course, Model model) {
		courseService.update(course);
		model.addAttribute("listCourse",courseService.findAll());
		return "redirect:course-list";
	}

	@RequestMapping("/courseDelete/{id}")
	public String doDeleteCourse(@PathVariable int id, Model model) {
		courseService.delete(id);
		model.addAttribute("listCourse", courseService.findAll());
		return "redirect:/course-list";
	}
	
	@RequestMapping(value = {"/course-student/{id}" })
	public String studentCourse(@ModelAttribute("Course") Course course,Model model) {
		
		model.addAttribute("course",courseService.courseStudent(course));
		return "redirect:student-list";
	}

}
