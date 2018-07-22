package help.spring.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer 
{
   @Autowired
   private KafkaTemplate<String, String> kafkaTemplate;
    
   public void send(String topic , String message) 
   {
        System.out.println("message send:" + message);
        kafkaTemplate.send(topic, message);
    }
}