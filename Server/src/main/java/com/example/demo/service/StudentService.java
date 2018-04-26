package com.example.demo.service;



import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entities.Course;
import com.example.demo.entities.Student;


@Service
@Transactional

public class StudentService {
	@Autowired
	private StudentDAO studentDAO;

	public List<Student> findAll() {
		
		return studentDAO.findAll();
	}

	public Student findById(final int id) {
		return studentDAO.findById(id);
	}

	public void save(final Student student) {
		studentDAO.save(student);
	}

	public void update(final Student student) {
		studentDAO.update(student);
	}

	public void delete(final int id) {
		Student student = studentDAO.findById(id);
		if (student != null) {
			studentDAO.delete(student);
		}
	}
	public List<Course> getlistCourse(final int id){
		return studentDAO.getlistCourse(id);
	}
	
	public void addCourse(final int id, List<Course> course) {
		studentDAO.addCourse(id, course);
	}
	public void removeCourse(final int idS,final int idC ) {
		studentDAO.removeCourse(idS, idC);
	}
	
//	public List<Student> findListStudent(){
//		return studentDAO.findListStudent();
//	}
}
