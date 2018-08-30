package log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringBootApp 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(SpringBootApp.class, args);
		//https://www.cnblogs.com/DeepLearing/p/5663178.html
        Logger logger = LoggerFactory.getLogger(Test.class);
        logger.info("info........");
        logger.warn("warn........");
        logger.debug("debug........");
        logger.trace("trace........");
        logger.error("error........");
	}
}
