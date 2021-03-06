package help;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html

@SpringBootApplication
@EnableFeignClients
@RestController
public class App 
{
	@Autowired
	ServiceA service;
	
	@RequestMapping(path="/test")
	String test()
	{
		return service.call();
	}
	public static void main(String[] args) 
	{
		SpringApplication.run(App.class, args);
	}

}
