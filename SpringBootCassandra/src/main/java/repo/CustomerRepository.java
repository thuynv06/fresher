package repo;
import org.springframework.data.cassandra.repository.CassandraRepository;

import model.Customer;

public interface CustomerRepository extends CassandraRepository<Customer,String> {

}
