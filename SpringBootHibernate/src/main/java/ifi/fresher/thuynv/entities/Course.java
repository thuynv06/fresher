package ifi.fresher.thuynv.entities;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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

@Entity
@Table(name = "course")

public class Course {

	@Id
	@Column(name = "idCourse")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCourse;
	@Column(name = "name")
	private String name;
	@Column(name = "price")
	private float price;

	@ManyToMany(mappedBy = "course")
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
	
//	@Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
// 
//        Course course = (Course) o;
// 
//        if (!idCourse.equals(course.idCourse)) return false;
//        return name.equals(course.name);
//    }
// 
//    @Override
//    public int hashCode() {
//        int result = idCourse.hashCode();
//        result = 31 * result + name.hashCode();
//        return result;
//    }

}
