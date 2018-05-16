package ifi.internaltool.allocation.repo;
import org.springframework.data.cassandra.repository.CassandraRepository;

import ifi.internaltool.allocation.model.Employee;

public interface EmployeeRepository extends  CassandraRepository<Employee,String> {

}
