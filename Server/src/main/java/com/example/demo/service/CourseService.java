package com.example.demo.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CourseDAO;
import com.example.demo.entities.Course;
import com.example.demo.entities.Student;



@Service
@Transactional

public class CourseService {
	@Autowired
	private CourseDAO courseDAO;

	public List<Course> findAll() {
		return courseDAO.findAll();
	}

	public Course findById(final int id) {
		return courseDAO.findById(id);
	}

	public void save(final Course course) {
		courseDAO.save(course);
	}

	public void update(final Course course) {
		courseDAO.update(course);
	}

	public void delete(final int id) {
		Course course = courseDAO.findById(id);
		if (course != null) {
			courseDAO.delete(course);
		}

	}
	public List<Student> getListStudent(final int id){
		return courseDAO.getListStudent(id);
	}

}
