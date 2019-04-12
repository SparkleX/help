package help.redis.spring.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String get(@RequestParam("id") String id) 
	{
		Person p = personService.getUserById(id);
		return p.getData();
	}
	@RequestMapping("/create")
	public void create(@RequestParam("id") String id, @RequestParam("data") String data) 
	{
		Person person = new Person();
		person.setId(id);
		person.setData(data);
		personService.update(person);
	}
	
	@RequestMapping("/update")
	public void update(@RequestParam("id") String id, @RequestParam("data") String data) 
	{
		Person person = new Person();
		person.setId(id);
		person.setData(data);
		personService.update(person);
	}	
	@RequestMapping("/remove")
	public void remove(@RequestParam("id") String id) 
	{
		personService.remove(id);
	}
}
