package help;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@EnableCircuitBreaker
@RestController
public class App 
{
	@Autowired
	TestComponent component;
	@RequestMapping("/test")
	public BigDecimal test() throws Exception
	{
		return component.getDiscount("ItemA");
	}
	public static void main(String[] args) 
	{
		SpringApplication.run(App.class, args);
	}
}