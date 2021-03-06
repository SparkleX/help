package help;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Worker
{
	@Autowired
	ApplicationContext appCtx;
	static Logger logger = LoggerFactory.getLogger(Worker.class);
	
	@Autowired
	private AmqpTemplate rabbitTemplate;	
	
	public static Integer a = 0;
	
	@Scheduled(cron = "*/5 * * * * ?")
	public void run() 
	{
		MessageBody mb = new MessageBody();
		mb.id = a++;
		mb.body = Integer.toString(a);
		System.out.println(a);
		rabbitTemplate.convertAndSend("test",mb);
		//System.out.println(test);
	}	
}
