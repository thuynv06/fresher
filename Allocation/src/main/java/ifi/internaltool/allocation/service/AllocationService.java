package ifi.internaltool.allocation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastax.driver.core.utils.UUIDs;

import ifi.internaltool.allocation.DAO.AllocationDAO;
import ifi.internaltool.allocation.DAO.EmployeeDAO;
import ifi.internaltool.allocation.DAO.GroupDAO;
import ifi.internaltool.allocation.DAO.ProjectDAO;
import ifi.internaltool.allocation.model.Allocation;


@Service
public class AllocationService {
	
	@Autowired
	private AllocationDAO allocationDAO;
	
	
	public List<Allocation> getAllAllocated(){	
		System.out.println("Get all Allocation...");
		return (List<Allocation>)allocationDAO.findAll();	
	}
	
	public Allocation createAllocation(final Allocation allocation) {
		System.out.println("Create Allocated: " );
		allocation.setId(UUIDs.timeBased());
		return allocationDAO.save(allocation);
		
		
	}
	
	

}
