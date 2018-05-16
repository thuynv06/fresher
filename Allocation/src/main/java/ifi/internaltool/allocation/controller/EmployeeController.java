package ifi.internaltool.allocation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifi.internaltool.allocation.model.Employee;
import ifi.internaltool.allocation.repo.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		System.out.println("Get all Employees...");
 
		List<Employee> list_emp = new ArrayList<>();
		employeeRepository.findAll().forEach(list_emp::add);
		return list_emp;
	}
	
	@PostMapping("/employees/create")
	public ResponseEntity<Employee> createCustomer(@Valid @RequestBody Employee emp) {
		System.out.println("Create Employees: " + emp.getName() + "...");
 
		emp.setId(UUIDs.timeBased());
		Employee _emp = employeeRepository.save(emp);
		return new ResponseEntity<>(_emp, HttpStatus.OK);
	}
	
}
