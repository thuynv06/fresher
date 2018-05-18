package ifi.internaltool.allocation.model;

import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table	
public class Group {
	@PrimaryKeyColumn(name = "group_id", type = PrimaryKeyType.PARTITIONED)
	private int group_id;
	@Column("name")
	@Indexed
	private String name;
	
	public Group() {
		
	}
	public Group(final int group_id,final String name) {
		this.group_id= group_id;
		this.name=name;
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
	
}
