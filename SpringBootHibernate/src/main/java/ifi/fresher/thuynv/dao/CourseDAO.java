package ifi.fresher.thuynv.dao;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ifi.fresher.thuynv.entities.Course;


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

}
