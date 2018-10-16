package help;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

//java -Dspring.profiles.active=dev -jar spring-profile-0.0.1-SNAPSHOT.jar


@SpringBootApplication
@Component
public class App implements InitializingBean
{
	@Value("${welcome.message}")
	private String welcomeMessage;
	public static void main(String[] args) 
	{
		SpringApplication.run(App.class, args);
		
	}
	@Override
	public void afterPropertiesSet() throws Exception
	{
		System.out.println(welcomeMessage);
		
	}
}