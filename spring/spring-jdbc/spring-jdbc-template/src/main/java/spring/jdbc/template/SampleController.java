package spring.jdbc.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController 
{
	@Autowired
	SampleService service;
	
	@RequestMapping("/get/{id}")
	public String get(@PathVariable Integer id)
	{
		return service.get(id);
	}
}
