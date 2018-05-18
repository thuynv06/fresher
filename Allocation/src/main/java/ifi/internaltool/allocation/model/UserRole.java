package ifi.internaltool.allocation.model;

import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

public class UserRole {
	@PrimaryKey
	private UUID id;
	@PrimaryKeyColumn(name = "user_id", type = PrimaryKeyType.PARTITIONED)
	private UUID user_id;
	@PrimaryKeyColumn(name = "role_id", type = PrimaryKeyType.PARTITIONED)

	private int role_id;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public UUID getUser_id() {
		return user_id;
	}
	public void setUser_id(UUID user_id) {
		this.user_id = user_id;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	
	
}
