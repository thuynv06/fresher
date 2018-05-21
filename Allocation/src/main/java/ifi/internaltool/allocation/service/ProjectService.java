package ifi.internaltool.allocation.service;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastax.driver.core.utils.UUIDs;

import ifi.internaltool.allocation.DAO.GroupDAO;
import ifi.internaltool.allocation.DAO.ProjectDAO;
import ifi.internaltool.allocation.model.Project;

@Service
public class ProjectService {

	@Autowired
	private ProjectDAO projectDAO;
	@Autowired
	private GroupDAO groupDAO;
	
	
	// get all projects
	public List<Project> getAllProjects(){	
		System.out.println("Get all Projects...");
		return (List<Project>)projectDAO.findAll();	
	}
	
	
	public List<Project>   getListProjects(){
		List<Project> ls= projectDAO.findAll();	
		for (Project p : ls) {
			getNameGroup(p);
		}
		return ls;
	}
	// create project
	
	public Project createProject(final Project project) {
		System.out.println("Create Project: " + project.getName() + "...");
		project.setProject_id(UUIDs.timeBased());
		return projectDAO.save(project);
	}
	
	public List<Project> findProjectByName(String name){
		return projectDAO.findByName(name);
	}
	
	public Project findById(final UUID id) {
		System.out.println("Find Project with id: " + id + "...");
		Project project=projectDAO.findById(id);
		getNameGroup(project);
		if( project == null) {
			return null;
		}
		return project;
	}
	
	public void updateProject(final UUID id,Project project) {
		System.out.println("Update Project with ID = " + id + "...");
		Project pro_data=projectDAO.findById( id);
		if( pro_data == null) {
			
		}
		pro_data.setName(project.getName());
		pro_data.setDesciption(project.getDesciption());
		pro_data.setGroup_id(project.getGroup_id());
		pro_data.setCreate_at(project.getCreate_at());
		projectDAO.save(pro_data);
		
	}
	public void deleteEmployee(final UUID id) {
		System.out.println("Delete Employee with ID = " + id + "...");
		projectDAO.deleteById(id);	
	}
	
	
	// function get Name group thought groupID
	public void getNameGroup(Project p) {
		p.setGroup_name(groupDAO.findNameGroupById(p.getGroup_id()));
	}
	
	
	
}
