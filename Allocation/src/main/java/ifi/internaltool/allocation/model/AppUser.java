package ifi.internaltool.allocation.model;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class AppUser {
	@PrimaryKey
	private UUID user_id;
	
	private String username;
	private String password;
	private boolean enable;
	public UUID getUser_id() {
		return user_id;
	}
	public void setUser_id(UUID user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ User: "+ username +" Password:"+ password + "+ enable: "+ enable + " ]";
	}
	
}
