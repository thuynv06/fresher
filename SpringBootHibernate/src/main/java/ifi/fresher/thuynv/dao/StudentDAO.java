package ifi.fresher.thuynv.dao;


import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ifi.fresher.thuynv.entities.Course;
import ifi.fresher.thuynv.entities.Student;

@Repository(value = "studentDAO")

@Transactional(rollbackFor = Exception.class)
public class StudentDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void save(final Student student) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(student);
	}

	public void update(final Student student) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(student);
	}

	public Student findById(final int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Student s= session.get(Student.class, id);
		return session.get(Student.class, id);
	}

	public void delete(final Student student) {
		Session session = this.sessionFactory.getCurrentSession();
		session.remove(student);
	}

	public List<Student> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Student> s=session.createQuery("FROM Student", Student.class).getResultList();	
//		List<Course>  c=s.get(0).getCourse();
		return s;
	}
	
	public List<Course> getStudentCourse(final int id){
		Session session = this.sessionFactory.getCurrentSession();
		List<Course> c= session.get(Student.class, id).getCourse();	
		c.forEach(x -> System.out.print(x.getName()));
		return c;
		
	}
	



}
