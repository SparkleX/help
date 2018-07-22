package app1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class App1Rest 
{
	@RequestMapping("/test1")
	public String test()
	{
		return "App1.test";
	}
}
