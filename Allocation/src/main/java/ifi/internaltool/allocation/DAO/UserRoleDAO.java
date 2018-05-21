package ifi.internaltool.allocation.DAO;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;





public interface UserRoleDAO extends  CassandraRepository<UserRoleDAO,String> {
	 
		@Query(value="SELECT role_id FROM user_role WHERE user_id=?0")
	    public int getRoleID(UUID role_id) ;
	      
}