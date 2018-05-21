package ifi.internaltool.allocation.DAO;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import ifi.internaltool.allocation.model.Allocation;

public interface AllocationDAO extends CassandraRepository<Allocation,String> {
	
	
	
}
