package querydsl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import entity.SalesOrder;

@SpringBootApplication
@EntityScan(basePackageClasses = SalesOrder.class)
public class AppWeb
{
	
	public static void main(String[] args)
	{
		SpringApplication.run(AppWeb.class, args);
	}
	
	
}
