package com.example.demo.entities;

import java.util.List;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "course")
@JsonIgnoreProperties(value= {"student"})
public class Course {

	@Id
	@Column(name = "idCourse")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCourse;
	@Column(name = "name")
	private String name;
	@Column(name = "price")
	private float price;

	@ManyToMany(fetch=FetchType.LAZY,mappedBy = "course")
	private List<Student> student;


	public List<Student> getStudent() {
		return student;
	}

	public Course() {
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public Course(String courseName) {
		this.name = courseName;
	}



	public int getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
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
