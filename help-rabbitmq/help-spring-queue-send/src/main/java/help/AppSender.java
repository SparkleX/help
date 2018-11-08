package help;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;



@SpringBootApplication
@EnableScheduling
public class AppSender 
{
	public static void main(String[]args)
	{
		SpringApplication.run(AppSender.class, args);
	}
}
