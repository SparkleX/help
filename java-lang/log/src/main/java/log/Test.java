package log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {

	public static void main(String[] args) 
	{
		//https://www.cnblogs.com/DeepLearing/p/5663178.html
        Logger logger = LoggerFactory.getLogger(Test.class);
        logger.info("info........");
        logger.warn("warn........");
        logger.debug("debug........");
        logger.trace("trace........");
        logger.error("error........");
        ch.qos.logback.core.ConsoleAppender a;
	}

}
