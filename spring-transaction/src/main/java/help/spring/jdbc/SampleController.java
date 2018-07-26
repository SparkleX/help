package help.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController 
{
	@Autowired
	SampleService service;
	
	//@Transactional(rollbackFor= Throwable.class)
	@Transactional
	@RequestMapping("/test")
	public String test() throws Exception
	{
		service.add();
		return "OK";
	}
}
