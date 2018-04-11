package ifi.fresher.thuynv.entities;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")

public class Course {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "price")
	private float price;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "course")
	private List<Student> course ;
	
	public List<Student> getCourses() {
		return course;
	}

	public void setCourses(List<Student> course) {
		this.course = course;
	}
	public Course() {
	}

	public Course(String courseName) {
		this.name = courseName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
