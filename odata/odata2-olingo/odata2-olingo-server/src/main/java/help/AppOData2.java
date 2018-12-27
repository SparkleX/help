package help;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("help")
public class AppOData2
{
	public static void main(String []args)
	{
		SpringApplication.run(AppOData2.class, args);
	}
}
