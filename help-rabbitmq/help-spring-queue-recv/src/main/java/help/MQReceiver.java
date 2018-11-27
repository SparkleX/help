package help;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = "test",concurrency="10")
public class MQReceiver  
{
    protected Logger logger = LoggerFactory.getLogger(MQReceiver.class); 
  
    @RabbitHandler
    //@RabbitListener(queues = "test", containerFactory="rabbitListenerContainerFactory")
    public String process(@Payload MessageBody request) 
    {
    	logger.info("{}",Thread.currentThread().getId());
        logger.info("->" + request.id + " - "+request.body);
        //throw new RuntimeException("runtime");
        return "HelloWorld";
    }
}