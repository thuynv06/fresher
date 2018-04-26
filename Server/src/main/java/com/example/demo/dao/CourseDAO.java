package com.example.demo.dao;



import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Course;
import com.example.demo.entities.Student;



@Repository(value = "courseDAO")
@Transactional(rollbackFor = Exception.class)
public class CourseDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void save(final Course course) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(course);
	}

	public void update(final Course course) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(course);
	}

	public Course findById(final int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Course.class, id);
	}

	public void delete(final Course course) {
		Session session = this.sessionFactory.getCurrentSession();
		session.remove(course);
	}

	public List<Course> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Course", Course.class).getResultList();
	}
	public List<Student> getListStudent(final int id){
		Session session = this.sessionFactory.getCurrentSession();
		List<Student> s= session.get(Course.class, id).getStudent();	
		s.forEach(x -> System.out.print(x.getName()));
		return s;
	}

}
