package ifi.internaltool.allocation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.mapping.BasicMapId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.datastax.driver.core.utils.UUIDs;

import ifi.internaltool.allocation.DAO.EmployeeDAO;
import ifi.internaltool.allocation.DAO.GroupDAO;
import ifi.internaltool.allocation.model.Employee;
import ifi.internaltool.allocation.model.Project;


@Service
public class EmployeeService  {
	
	@Autowired 
	private EmployeeDAO employeeDAO;
	@Autowired
	private GroupDAO groupDAO;
	// get All Employees
	public List<Employee> getAllEmployees(){	
		System.out.println("Get all Employees...");
		return (List<Employee>)employeeDAO.findAll();	
	}
	
	
	public List<Employee> getListEmployees(){	
		
		List<Employee> ls= employeeDAO.findAll();
		for (Employee emp : ls) {
			getNameGroup(emp);
		}
		
		return ls;
	}
	
	// create Employees
	public Employee createEmployee(final Employee emp) {
		System.out.println("Create Employees: " + emp.getName() + "...");
		emp.setUser_id(UUIDs.timeBased());
		Employee employee=employeeDAO.save(emp);
		return employee;
	}
	
	public List<Employee> findEmployeeByName(String name){
		return employeeDAO.findByName(name);
	}
	
	public Employee findById(final UUID id) {
		System.out.println("Find Employees with id: " + id + "...");
		Employee emp=employeeDAO.findById(id);
		getNameGroup(emp);
		if( emp == null) {
			return null;
		}
		return emp;
	}
	
	public void updateEmployee(final UUID id,Employee emp) {
		System.out.println("Update Employess with ID = " + id + "...");
		Employee emp_data=employeeDAO.findById( id);
		if( emp == null) {
			
		}
		emp_data.setName(emp.getName());
		emp_data.setAge(emp.getAge());
		emp_data.setAddress(emp.getAddress());
		employeeDAO.save(emp_data);
		
	}
	
	public void deleteEmployee(final UUID id) {
		System.out.println("Delete Employee with ID = " + id + "...");
		employeeDAO.deleteById(id);	
	}
	
	//
	public void getNameGroup(Employee emp) {
		emp.setName_group(groupDAO.findNameGroupById(emp.getGroup_id()));
	}
	
}