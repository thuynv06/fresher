package ifi.internaltool.allocation.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.exceptions.ConnectionException;

import ifi.internaltool.allocation.model.Allocation;
import ifi.internaltool.allocation.model.Constants;
import ifi.internaltool.allocation.model.Payload;
import ifi.internaltool.allocation.service.AllocationService;

@RestController
@RequestMapping("/api")
public class AllocationController {
	
	@Autowired
	private AllocationService allocationService;
	
	private static final Logger logger = LoggerFactory.getLogger(AllocationController.class);
	Payload message = new Payload();
	
	Constants c = new Constants();
	
	Object data = "";
	
	@PostMapping("/allocations/create")
	public @ResponseBody Payload createEmployee(@Valid @RequestBody Allocation allocation) {
		logger.info("Create Allocation = ");
		try {
			data = allocationService.createAllocation(allocation);
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
	
	@GetMapping("/allocations")
	public @ResponseBody Payload getAllAllocation() {
		logger.info("get All Allocation = ");
		try {
			data = allocationService.getAllAllocated();

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
	

}
