package help.spring.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App
{
	public static void main(String[] args)
	{
		ApplicationContext appCtx = SpringApplication.run(App.class, args);
		Producer producer = appCtx.getBean(Producer.class);
		producer.send("test", "hello world");
	}
}
