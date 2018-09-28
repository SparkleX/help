package help;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LogApp 
{
	static Logger log = LoggerFactory.getLogger(LogApp.class);
	public static void main(String[] args) throws Exception 
	{
		SpringApplication.run(LogApp.class, args);
		log.info("hello world");
	}

}
