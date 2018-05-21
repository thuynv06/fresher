package ifi.internaltool.allocation.model;

import java.util.Map;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import jnr.ffi.annotations.Transient;



@Table
public class Employee {
	@PrimaryKeyColumn(name = "user_id", type = PrimaryKeyType.PARTITIONED)
	private UUID user_id;
	
	private int group_id;
	@Column("name")
	@Indexed
	private String name;
	
	@Column("age")
	private int age;
	
	@Column("address")
	private String address;
	@Column("reference")
	private Map< String, String> reference;	
	
	
	private transient String name_group;
	
	
	public String getName_group() {
		return name_group;
	}
	 
	public void setName_group(String name_group) {
		this.name_group = name_group;
	}
	public Employee(){
		
	}
	public Employee(final UUID user_id, final int group_id, final String name, final int age, final String address,
			final Map<String,String> reference) {
		this.user_id = user_id;
		this.group_id= group_id;
		this.name= name;
		this.age= age;
		this.address= address;
		this.reference= reference;
		
	}
	
	public UUID getUser_id() {
		return user_id;
	}

	public void setUser_id(UUID user_id) {
		this.user_id = user_id;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
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
