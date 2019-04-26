package spring.jdbc.repository.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;

import spring.jdbc.repository.domain.Customer;

public interface CustomerRepo extends JdbcRepository<Customer,Integer>
{
	@Query("select * from OCRD")
	List<Customer> findAllCustomers();
}
