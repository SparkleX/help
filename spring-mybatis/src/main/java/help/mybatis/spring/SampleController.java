package help.mybatis.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController 
{
	@Autowired
	SampleService service;
	
	@RequestMapping("/test")
	public List<Customer> get()
	{
		return service.get();
	}
}
