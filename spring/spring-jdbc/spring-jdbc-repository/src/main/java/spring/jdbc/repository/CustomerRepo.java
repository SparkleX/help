package spring.jdbc.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import spring.jdbc.repository.domain.Customer;

public interface CustomerRepo extends CrudRepository<Customer,Integer> 
{
	@Query("select * from OCRD")
	List<Customer> findAllCustomers();
}
