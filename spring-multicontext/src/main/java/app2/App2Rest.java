package app2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class App2Rest 
{
	@RequestMapping("/test2")
	public String test()
	{
		return "App2.test";
	}
}
