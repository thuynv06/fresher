package ifi.internaltool.allocation.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import ifi.internaltool.allocation.model.Constants;
import ifi.internaltool.allocation.model.Employee;
import ifi.internaltool.allocation.model.Payload;
import ifi.internaltool.allocation.model.Project;
import ifi.internaltool.allocation.service.ProjectService;

@RestController
@RequestMapping("/api")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	Payload message = new Payload();
	Constants c = new Constants();
	Object data = "";	
	
	@GetMapping("/allprojects")
	public @ResponseBody Payload getAllProjects() {
		logger.info("get All Projects = ");
		try {
			data = projectService.getAllProjects();

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
	
	@GetMapping("/projects")
	public @ResponseBody Payload getListProjects() {
		logger.info("get list Projects = ");
		try {
			data = projectService.getListProjects();

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
	
	@PostMapping("/projects/create")
	public @ResponseBody Payload createProject(@Valid @RequestBody Project project) {
		logger.info("Create Project = ");
		try {
			data = projectService.createProject(project);
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
	
	// update Project
		@PutMapping("/projects/{id}")
		public @ResponseBody Payload updateProject(@PathVariable("id") UUID id, @RequestBody Project project) {
			logger.info("Update Employess = " + project.getName());
			try {
				Project project_edit= projectService.findById(id);

			} catch (ConnectionException e) {
				logger.error("ERROR: Get connection error", e);
				message.setDescription("ERROR: " + e.getMessage());
				message.setData(data);
				message.setStatus(c.STATUS_OK());
				return message;
			}

			projectService.updateProject(id, project);
			data = projectService.findById(id);
			message.setPayload(c.SUCCESS_CODE(), c.STATUS_OK(), "Update Successfull", data);
			return message;

		}
	
		// search projects by name
		@GetMapping("/projects/{name}")
		public @ResponseBody Payload findProjectByName(@PathVariable String name) {

			logger.info("get projects By Name = " + name + "]");

			try {
				data =projectService.findProjectByName(name);

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
		
		// fint project by ID
		@GetMapping("/projects/{id}")
		public @ResponseBody Payload findById(@PathVariable("id") UUID id) {
			logger.info("get Project By Id = " + id + "]");
			try {
				data = projectService.findById(id);

			} catch (ConnectionException e) {
				logger.error("ERROR: Get connection error", e);
				message.setDescription("ERROR: " + e.getMessage());
				message.setData(data);
				message.setStatus(c.STATUS_OK());
				return message;
			}
			message.setPayload(c.SUCCESS_CODE(), c.STATUS_OK(), " Get Project data Successfull", data);
			return message;
		}
		// delete project by ID
		
		@DeleteMapping("/projects/{id}")
		public @ResponseBody Payload deleteProject(@PathVariable("id") UUID id) {
			logger.info("Delete Project with Id = " + id + "]");
			try {
				projectService.deleteEmployee(id);

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
