package help.spring.rest.requestmapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestService 
{
	@RequestMapping("/test")
	public String create() throws InterruptedException
	{
		Thread.sleep(2000);
		return "ok";
	}
}