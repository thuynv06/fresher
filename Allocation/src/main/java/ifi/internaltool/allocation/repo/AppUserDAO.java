package ifi.internaltool.allocation.repo;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import ifi.internaltool.allocation.model.AppUser;
import ifi.internaltool.allocation.model.Employee;

@Repository
public interface AppUserDAO extends  CassandraRepository<AppUser,String> {

@Query("select * from app_user where username= ?0;")
public AppUser findUserAccount(String username);





}
