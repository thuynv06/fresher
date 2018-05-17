package ifi.internaltool.allocation.repo;
import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.MapId;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.cassandra.repository.Query;

import ifi.internaltool.allocation.model.Employee;
//import ifi.internaltool.allocation.service.Query;
@Repository
public interface EmployeeRepository extends  CassandraRepository<Employee,String> {



	@AllowFiltering
	public List<Employee> findByName(String name);
	
	@Query(value="SELECT * FROM employee WHERE user_id=?0")
	public Employee findById(MapId id);
	
	
}
