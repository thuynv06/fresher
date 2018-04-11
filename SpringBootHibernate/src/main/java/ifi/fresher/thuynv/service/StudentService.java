package ifi.fresher.thuynv.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ifi.fresher.thuynv.dao.StudentDAO;
import ifi.fresher.thuynv.entities.Student;



@Service
@Transactional
public class StudentService {
	 @Autowired
	 	private StudentDAO studentDAO;
	 	
	 public List<Student> findAll(){
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
		 Student student=studentDAO.findById(id);
		 if(student != null) {
			 studentDAO.delete(student);
		 }
		 
	 }
	 
}
