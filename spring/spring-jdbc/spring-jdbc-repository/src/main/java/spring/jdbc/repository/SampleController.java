package spring.jdbc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.jdbc.repository.domain.Customer;
import spring.jdbc.repository.domain.ItemWarehouse;

@RestController
public class SampleController 
{
	@Autowired
	SampleService service;
	
	@RequestMapping("/get/{id}")
	public Customer get(@PathVariable Integer id)
	{
		return service.get(id);
	}
	
	@RequestMapping("/findAll")
	public List<Customer> findAll()
	{
		return service.findAll();
	}
	
	@RequestMapping("/get/oitw")
	public Iterable<ItemWarehouse> get()
	{
		return service.findAllItemWarehouse();
	}
}
