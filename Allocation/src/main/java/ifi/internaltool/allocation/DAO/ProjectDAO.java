package ifi.internaltool.allocation.DAO;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import ifi.internaltool.allocation.model.Project;

public interface ProjectDAO extends  CassandraRepository<Project,String> { 
	
	@Query(value="SELECT * FROM project WHERE name=?0")
	public List<Project> findByName(String name);
	
	@Query(value="SELECT * FROM project WHERE project_id=?0")
	public Project findById(UUID id);
	
	@Query(value="Delete  FROM project WHERE project_id=?0")
	public Project deleteById(UUID id);
	
	@Query(value="Select *  FROM project WHERE group_id=?0 allow filtering")
	public Project findWithGroup(int id);

}
