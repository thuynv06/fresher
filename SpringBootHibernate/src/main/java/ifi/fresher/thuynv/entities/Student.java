package ifi.fresher.thuynv.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



import javax.persistence.CascadeType;
import ifi.fresher.thuynv.entities.Course;

@Entity
@Table(name = "student")
public class Student  {

	@Id
	@Column(name = "idStudent")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idStudent;
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private int age;
	@Column(name = "address")
	private String address;
	@Column(name = "phone")
	private String phone;

	
	public Student(String studentName) {
		this.name = studentName;
	
	}

	@ManyToMany( cascade = CascadeType.ALL)
	@JoinTable(name = "student_course", joinColumns = { @JoinColumn(name = "student_id") }, inverseJoinColumns = {
			@JoinColumn(name = "course_id") })
//	private Collection<Course> c;
//	public Collection<Course> getC() {
//		return c;
//	}
//
//	public void setC(Collection<Course> c) {
//		this.c = c;
//	}

	private List<Course> course;
//
//
//	public void setCourses(List<Course> courses) {
//		this.course = courses;
//	}

	public Student() {

	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	
	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	//
	public Student(String name, int age, String address, String phone) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.phone = phone;

	}

	// getter - setter
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}