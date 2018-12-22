package help;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableFeignClients
@RestController
public class App 
{
	@Autowired
	ServiceA service;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(path="/test")
	HashMap test()
	{
		HashMap map = new HashMap();
		map.put("key1", "1");
		map.put("key2", "2");
		return service.call();
	}
	public static void main(String[] args) 
	{
		SpringApplication.run(App.class, args);
	}

}
