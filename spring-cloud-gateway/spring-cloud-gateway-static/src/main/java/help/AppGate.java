package help;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;




@SpringBootApplication
public class AppGate
{
	public static void main(String[] args)
	{
		System.setProperty("spring.profiles.active", "dev");
        SpringApplication.run(AppGate.class, args);
	}
}
