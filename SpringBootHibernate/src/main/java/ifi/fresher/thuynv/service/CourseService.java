package ifi.fresher.thuynv.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ifi.fresher.thuynv.dao.CourseDAO;
import ifi.fresher.thuynv.entities.Course;
import ifi.fresher.thuynv.entities.Student;

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

	public List<Student> courseStudent(final Course course) {
		return courseDAO.courseStudent(course);
	}

}
