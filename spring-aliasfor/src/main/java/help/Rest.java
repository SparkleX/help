package help;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;

@MyService("/test")
public class Rest 
{
	@Autowired
	ApplicationContext appCtx;
	@RequestMapping("/test")
	public String test()
	{
		Rest a = (Rest) appCtx.getBean("/test");
		return "test";
	}
}
