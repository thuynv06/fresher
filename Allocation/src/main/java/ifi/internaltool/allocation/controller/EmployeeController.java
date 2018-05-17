package ifi.internaltool.allocation.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.utils.UUIDs;

import ifi.internaltool.allocation.model.Employee;
import ifi.internaltool.allocation.repo.EmployeeRepository;
import ifi.internaltool.allocation.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired 
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@PostMapping("/employees/create")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee emp) {
		Employee _emp = employeeService.createEmployee(emp);
		return new ResponseEntity<>(_emp, HttpStatus.OK);
	}
	
	@GetMapping("/employees/{name}")
	public List<Employee> findEmPloyeeByName(@PathVariable  String name) {
		return employeeService.findEmployeeByName(name);
	}
	@GetMapping("/employees/id/{id}")
	public Employee findById(@PathVariable ("id") UUID id) {
		return employeeService.findById(id);
	}
	
}
