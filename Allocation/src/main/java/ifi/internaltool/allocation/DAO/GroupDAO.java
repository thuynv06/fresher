package ifi.internaltool.allocation.DAO;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import ifi.internaltool.allocation.model.Group;

public interface GroupDAO extends  CassandraRepository<Group,String> {
	
	@Query(value="SELECT * FROM group WHERE name=?0")
	public List<Group> findByName(String name);
	
	@Query(value="SELECT * FROM group WHERE group_id=?0")
	public Group findById(int id);
	
	@Query(value="Delete  FROM group WHERE group_id=?0")
	public Group deleteById(int id);
	
	
	@Query(value="Select name  FROM group WHERE group_id=?0")
	public String findNameGroupById(int id);
	
}
