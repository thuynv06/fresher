package ifi.internaltool.allocation.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.exceptions.ConnectionException;
import com.datastax.driver.core.utils.UUIDs;

import ifi.internaltool.allocation.DAO.EmployeeDAO;
import ifi.internaltool.allocation.model.Constants;
import ifi.internaltool.allocation.model.Employee;
import ifi.internaltool.allocation.model.Payload;
import ifi.internaltool.allocation.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	Payload message = new Payload();
	Constants c = new Constants();
	Object data = "";

	// get All Employees
	@GetMapping("/allemployees")
	public @ResponseBody Payload getAllEmployees() {
		logger.info("get All Employess = ");
		try {
			data = employeeService.getAllEmployees();

		} catch (ConnectionException e) {
			logger.error("ERROR: Get connection error", e);
			message.setDescription("ERROR: " + e.getMessage());
			message.setData(data);
			message.setStatus(c.STATUS_OK());
			return message;
		}
		message.setPayload(c.SUCCESS_CODE(), c.STATUS_OK(), " Get site data Successfull", data);
		return message;
	}
	
	
	
	@GetMapping("/employees")
	public @ResponseBody Payload getListEmployees() {
		logger.info("get All Employess = ");
		try {
			data = employeeService.getListEmployees();

		} catch (ConnectionException e) {
			logger.error("ERROR: Get connection error", e);
			message.setDescription("ERROR: " + e.getMessage());
			message.setData(data);
			message.setStatus(c.STATUS_OK());
			return message;
		}
		message.setPayload(c.SUCCESS_CODE(), c.STATUS_OK(), " Get site data Successfull", data);
		return message;
	}
	

	// create Employee
	@PostMapping("/employees/create")
	public @ResponseBody Payload createEmployee(@Valid @RequestBody Employee emp) {
		logger.info("Create Employess = ");
		try {
			data = employeeService.createEmployee(emp);
		} catch (ConnectionException e) {
			logger.error("ERROR: Get connection error", e);
			message.setDescription("ERROR: " + e.getMessage());
			message.setData(data);
			message.setStatus(c.STATUS_OK());
			return message;
		}
		message.setPayload(c.SUCCESS_CODE(), c.STATUS_OK(), " Create Successfull", data);
		return message;
	}

	// update Employee
	@PutMapping("/employees/{id}")
	public @ResponseBody Payload updateEmployee(@PathVariable("id") UUID id, @RequestBody Employee emp) {
		logger.info("Update Employess = " + emp.getName());
		try {
			Employee employee = employeeService.findById(id);

		} catch (ConnectionException e) {
			logger.error("ERROR: Get connection error", e);
			message.setDescription("ERROR: " + e.getMessage());
			message.setData(data);
			message.setStatus(c.STATUS_OK());
			return message;
		}

		employeeService.updateEmployee(id, emp);
		data = employeeService.findById(id);
		message.setPayload(c.SUCCESS_CODE(), c.STATUS_OK(), "Update Successfull", data);
		return message;

	}

	// search employees by name
	@GetMapping("/employees/{name}")
	public @ResponseBody Payload findEmPloyeeByName(@PathVariable String name) {

		logger.info("get Employee By Name = " + name + "]");

		try {
			data = employeeService.findEmployeeByName(name);

		} catch (ConnectionException e) {
			logger.error("ERROR: Get connection error", e);
			message.setDescription("ERROR: " + e.getMessage());
			message.setData(data);
			message.setStatus(c.STATUS_OK());
			return message;
		}
		message.setPayload(c.SUCCESS_CODE(), c.STATUS_OK(), " Get site data Successfull", data);
		return message;
	}

	// search employees by ID
	@GetMapping("/employees/{id}")
	public @ResponseBody Payload findById(@PathVariable("id") UUID id) {
		logger.info("get Employee By Id = " + id + "]");
		try {
			data = employeeService.findById(id);

		} catch (ConnectionException e) {
			logger.error("ERROR: Get connection error", e);
			message.setDescription("ERROR: " + e.getMessage());
			message.setData(data);
			message.setStatus(c.STATUS_OK());
			return message;
		}
		message.setPayload(c.SUCCESS_CODE(), c.STATUS_OK(), " Get site data Successfull", data);
		return message;
	}

	@DeleteMapping("/employees/{id}")
	public @ResponseBody Payload deleteEmployee(@PathVariable("id") UUID id) {
		logger.info("Delete Employee with Id = " + id + "]");
		try {
			employeeService.deleteEmployee(id);

		} catch (ConnectionException e) {
			logger.error("ERROR: Get connection error", e);
			message.setDescription("ERROR: " + e.getMessage());
			message.setData(data);
			message.setStatus(c.STATUS_OK());
			return message;
		}
		message.setPayload(c.SUCCESS_CODE(), c.STATUS_OK(), " Delete Successfull", data);
		return message;
	}
}
