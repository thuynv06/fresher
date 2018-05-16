package ifi.internaltool.allocation.model;

import java.util.Map;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table	
public class Employee {
	@PrimaryKey
	private long user_id;
	private long group_id;
	private String name;
	private int age;
	private String address;
	
	private Map< String, String> reference;	
	
	public Employee(){
		
	}
	
	
	
	
	public long getUser_id() {
		return user_id;
	}




	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}




	public long getGroup_id() {
		return group_id;
	}




	public void setGroup_id(long group_id) {
		this.group_id = group_id;
	}




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




	public Map<String, String> getReference() {
		return reference;
	}




	public void setReference(Map<String, String> reference) {
		this.reference = reference;
	}




	@Override
	public String toString() {
		return "Employee [id=" + user_id+ ", name= " + name + ",age=" + age
				+ ", address=" + address+ "]";
	}
	
}
