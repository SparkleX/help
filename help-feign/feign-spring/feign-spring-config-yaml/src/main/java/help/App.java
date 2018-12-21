package help;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

//https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html

@SpringBootApplication
@EnableFeignClients
public class App {

	public static void main(String[] args) 
	{
		ApplicationContext appContext = SpringApplication.run(App.class, args);
		ServiceA service = appContext.getBean(ServiceA.class);
		
		service.call("123");
		appContext.getBean(ServiceB.class);
	}

}
