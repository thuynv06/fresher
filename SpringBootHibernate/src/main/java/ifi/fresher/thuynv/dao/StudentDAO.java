package ifi.fresher.thuynv.dao;

import java.util.Arrays;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
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
	public List<Course> studentCourse(final int id) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql="select course.name from course join student_course "
				+"on course.id=student_course.course_id " + "where student_course.student_id =" + id;
		
		List<Course> course=session.createQuery(hql).list();
		
		 return course;
		
//		String query = "select student.name from student join course on "
//				+ "student.id=student_course.student_id ";  
//		session.createQuery(query);
//		student.setCourses(Arrays.asList(course));
//		Session session = this.sessionFactory.getCurrentSession();
//		session.save(course);
//		session.getTransaction().commit();
//		session.close();
	}
}
