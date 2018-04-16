package ifi.fresher.thuynv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ifi.fresher.thuynv.service.CourseService;
import ifi.fresher.thuynv.service.StudentService;

@Controller
@RequestMapping (value = {"/" })
public class MainController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value = {"/"})
	public String index(Model model) {
		model.addAttribute("listCourse", courseService.findAll());
		model.addAttribute("listStudent", studentService.findAll());
		return "index";
	}
}
