package help;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication
@ServletComponentScan("myservice.mynamespace")
public class AppOData
{

	public static void main(String[] args)
	{
		SpringApplication.run(AppOData.class, args);
	}

}
