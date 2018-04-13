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
		return session.get(Student.class, id);
	}

	public void delete(final Student student) {
		Session session = this.sessionFactory.getCurrentSession();
		session.remove(student);
	}

	public List<Student> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("FROM Student", Student.class).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Course> studentCourse(final Student student ) {
//		Session session = this.sessionFactory.getCurrentSession();
//		Query query;
//		query = session.createQuery(
//		"select course.name from course join student_course "
//				+"on course.id=student_course.course_id " + "where student_course.student_id =" + student.getId(),Student.class);	
//		return query.getResultList();
//	
		return  student.getC();
		
	}

}
