package help;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App
{
	@Autowired
	EntityManager em;
	
	@RequestMapping("/test")
	public String test()
	{
		return null;
		
	}
	public static void main(String[] args)
	{
			ConfigurableApplicationContext appCtx = SpringApplication.run(App.class, args);
			appCtx.getBean(EntityManager.class);

	}

}
