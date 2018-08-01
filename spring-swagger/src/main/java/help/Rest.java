package help;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest 
{
	@RequestMapping(path="/test1", method = RequestMethod.GET)
	public String test(@RequestParam String param1,
			@RequestParam Integer param2)
	{
		return "App1.test";
	}
	
	
	@RequestMapping(path="/test2", method = RequestMethod.GET)
	public BeanParam test2(BeanParam param)
	{
		BeanParam rt =  new BeanParam();
		rt.setId(1);
		rt.setCode("2");
		return rt;
	}
}
