package help.spring.rest.requestmapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@RequestMapping("/test/order")
public class App 
{
	@RequestMapping("/create")
	public String create()
	{
		return "order.create";
	}
	public static void main(String[] args) 
	{
		SpringApplication.run(App.class, args);
	}
}