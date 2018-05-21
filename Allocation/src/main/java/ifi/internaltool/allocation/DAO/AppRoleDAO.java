package ifi.internaltool.allocation.DAO;
import org.springframework.data.cassandra.repository.CassandraRepository;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import ifi.internaltool.allocation.model.AppRole;

import java.util.List;


public interface AppRoleDAO extends  CassandraRepository<AppRole,String> {
	 
		@Query(value="SELECT * FROM app_role WHERE name=?0")
	    public List<String> getRoleNames(int role_id) ;
	      
}
