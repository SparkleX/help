package nosql.cassandra.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableCassandraRepositories
public class Application 
{
	@Autowired
	EmployeeRepository repo;
	
	@GetMapping("/test")
	public List<Employee> test()
	{
		List<Employee> list = repo.findTest(2);
		return list;
	}
	
	static public void main(String[]args)
	{
		SpringApplication.run(Application.class, args);
		
	}
}
