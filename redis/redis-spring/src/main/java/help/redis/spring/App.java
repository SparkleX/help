package help.redis.spring;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableRedisRepositories
@Component
public class App 
{
	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	PersonRepository repoPerson;
	
	public static void main(String[] args) 
	{
		try(ConfigurableApplicationContext appContext = SpringApplication.run(App.class, args))
		{
			App app = appContext.getBean(App.class);
			app.test();
		}
	}

	private void test() 
	{
		/*Person person = new Person();
		person.setId("2");
		person.setData("aaddbb2");
		person.setFirstname("firstName2");
		repoPerson.save(person );*/
		Optional<Person> oPerson = repoPerson.findById("2");
		Person person = oPerson.get();
		person.setFirstname("changed2");
		
		repoPerson.save(person);
	}
}
