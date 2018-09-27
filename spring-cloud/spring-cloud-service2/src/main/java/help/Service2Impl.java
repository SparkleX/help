package help;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service2Impl implements Service2 
{
	private static Logger logger = LoggerFactory.getLogger(Service2Impl.class);
    @GetMapping("/")
    public String helloSleuth() 
    {
        logger.info("Hello Sleuth");
        return "success";
    }
	@Override
	public String hello(String str) 
	{
		return "Hello World:" + str;
	}
}