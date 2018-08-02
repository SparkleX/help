package cloud.eureka.service;

import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
//@EnableCircuitBreaker
@EnableDiscoveryClient
@RestController
public class App 
{
	
	@RequestMapping("/test")
	public String test()
	{
		return guid;
	}
	static String guid;
    public static void main( String[] args )
    {
    	guid = UUID.randomUUID().toString();
    	System.setProperty("eureka.instance.instance-id",guid);
    	SpringApplication.run(App.class, args);
    }
}
