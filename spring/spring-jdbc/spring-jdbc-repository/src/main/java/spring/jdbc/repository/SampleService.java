package spring.jdbc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.jdbc.repository.domain.Customer;
import spring.jdbc.repository.domain.ItemWarehouse;
import spring.jdbc.repository.repository.CustomerRepo;
import spring.jdbc.repository.repository.ItemWarehouseRepo;

@Service
public class SampleService 
{
	@Autowired
	CustomerRepo repoCustomer;
	@Autowired
	ItemWarehouseRepo repoItemWarehouse;
//	@Autowired
//	JdbcTemplate jdbcTemplate;
	@Transactional
	public Customer get(int id) 
	{
		Customer entity = new Customer();
		entity.setName("123");
		repoCustomer.add(entity);
		return repoCustomer.findById(id).get();
	}

	public List<Customer> findAll() {
		return repoCustomer.findAllCustomers();
	}
	public Iterable<ItemWarehouse> findAllItemWarehouse() {
		return repoItemWarehouse.findAll();
	}
}
