package help;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// set DOCKER_HOST=tcp://???IP:2375

@SpringBootApplication
@RestController
public class App 
{
	@RequestMapping("/test")
	public String test()
	{
		return "Hello Docker";
	}
    public static void main( String[] args )
    {
    	System.out.println("Hello World");
    	SpringApplication.run(App.class, args);
    }
}
