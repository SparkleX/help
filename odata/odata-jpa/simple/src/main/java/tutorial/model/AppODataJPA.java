package tutorial.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("tutorial")
@EntityScan("help")
public class AppODataJPA
{
	static public void main(String[]argc)
	{
		SpringApplication.run(AppODataJPA.class, argc);
	}
}
