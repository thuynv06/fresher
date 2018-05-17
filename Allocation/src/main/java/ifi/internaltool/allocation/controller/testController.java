package ifi.internaltool.allocation.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.apache.logging.log4j.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.exceptions.ConnectionException;

import ifi.internaltool.allocation.model.Payload;
import ifi.internaltool.allocation.service.EmployeeService;

@RestController

public class testController {
	@Autowired 
	private EmployeeService employeeService;
	
	private static final Logger logger = LoggerFactory.getLogger(testController.class);

	@RequestMapping("/test")
	public @ResponseBody Payload getEmployees() {
		logger.info("get all employees");

		Payload message = new Payload();
		Object data = "";

		try {
			data = employeeService.getAllEmployees();
			
		} catch (ConnectionException e) {
			
			logger.error("ERROR: Get connection error", e);
			message.setDescription("ERROR: " + e.getMessage());
			message.setData(data);
			message.setStatus(Constants.LOG4J2_DEBUG);
			return message;
		}
		
		message.setCode("Success code");
		message.setStatus("OK");
		message.setDescription("Get site data successfully");
		message.setData(data);
		return message;
	}
}