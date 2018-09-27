package help;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service1Impl 
{
	private static Logger logger = LoggerFactory.getLogger(Service1Impl.class);
    @GetMapping("/")
    public String helloSleuth() 
    {
        logger.info("Hello Sleuth");
        return "success";
    }
    
    @Autowired
    Service2 service2;
    
    @RequestMapping("/service1")
    public String hello(@RequestParam String str) 
    {
        logger.info("Hello Sleuth");
        return service2.hello(str + " service1");
    }
}