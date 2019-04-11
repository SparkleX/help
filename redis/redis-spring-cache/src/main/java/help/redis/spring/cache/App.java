package help.redis.spring.cache;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableRedisRepositories
@Component
@EnableCaching
@EnableScheduling
@RestController
public class App 
{

	@Autowired
	PersonService personService;
	
	public static void main(String[] args) 
	{
		SpringApplication.run(App.class, args);
	}

	@RequestMapping("/get")
	public String get() 
	{
		Person p = personService.getUserById("1");
		return p.getData();
	}
	@RequestMapping("/create")
	public void create() 
	{
		Person person = new Person();
		person.setId("100");
		person.setData("data");
		personService.update(person);
	}
	
}
