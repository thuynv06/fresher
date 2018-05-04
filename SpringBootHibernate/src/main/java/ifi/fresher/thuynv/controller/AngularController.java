package ifi.fresher.thuynv.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import ifi.fresher.thuynv.entities.Course;
import ifi.fresher.thuynv.entities.Student;
import ifi.fresher.thuynv.service.CourseService;
import ifi.fresher.thuynv.service.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/")
class AngularController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private CourseService courseService;
	
	@GetMapping(value="/students")
	public List<Student> findAll(){
		List<Student> listStu= studentService.findAll();
		return listStu;
	}
	@GetMapping("/courses")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Course> listCourse(){
		List<Course> listC= courseService.findAll();
		return listC;
	}
	@RequestMapping(value = "students/{idStudent}", method = RequestMethod.GET)
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
	
	
}
