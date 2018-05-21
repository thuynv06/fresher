package ifi.internaltool.allocation.service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastax.driver.core.utils.UUIDs;

import ifi.internaltool.allocation.DAO.GroupDAO;
import ifi.internaltool.allocation.model.Employee;
import ifi.internaltool.allocation.model.Group;

@Service
public class GroupService {
	
	@Autowired
	private GroupDAO groupDAO;
	Random random;
	public List<Group> getAllGroup(){	
		System.out.println("Get all Group...");
		return (List<Group>)groupDAO.findAll();	
	}
	public Group createGroup(final Group group) {
		System.out.println("Create Group: " + group.getName() + "...");
		group.setGroup_id(random.nextInt());
		Group newGroup=groupDAO.save(group);
		return newGroup;
	}
	
	public List<Group> findEmployeeByName(String name){
		return groupDAO.findByName(name);
	}
	
	public Group findById(final int id) {
		System.out.println("Find Group with id: " + id + "...");
		Group group=groupDAO.findById(id);
		if( group == null) {
			return null;
		}
		return group;
	}
	
	public String findNameGroupById(final int id) {
		System.out.println("Find Name Group with id: " + id + "...");
		String name=groupDAO.findNameGroupById(id);
		if( name == null) {
			return null;
		}
		return name;
	}
	
	public void updateGroup(final int id, Group group) {
		System.out.println("Update Group with ID = " + id + "...");
		Group group_data=groupDAO.findById( id);
		if( group == null) {
			
		}
		group_data.setName(group.getName());
		groupDAO.save(group_data);
		
	}
	public void deleteEmployee(final int id) {
		System.out.println("Delete Group with ID = " + id + "...");
		groupDAO.deleteById(id);	
	}
	

}
