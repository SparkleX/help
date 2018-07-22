package help.spring.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer 
{
    @KafkaListener(topics = "${kafka.dataacquisition.topic}")
    public void receive(String message) 
    {
        System.out.println("message recv:" + message);
      //  Merchandise merchandise = JsonUtils.jsonToObject(message, Merchandise.class);
       // dataHandleService.handle(merchandise);
    }
}