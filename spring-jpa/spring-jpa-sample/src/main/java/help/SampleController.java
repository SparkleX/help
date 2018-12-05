package help;

import java.util.List;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController 
{
	@Autowired
	SampleService service;
	
	

	@Transactional(isolation=Isolation.READ_COMMITTED)
	@RequestMapping("/find/{id}")
	public List<Customer> find(@PathVariable Integer id)
	{
		return service.find(id);
	}
}
