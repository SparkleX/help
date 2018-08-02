package help.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class App 
{
	@RequestMapping("/test")
	public Bean test()
	{
		Bean rt = new Bean();
		rt.setId(100);
		rt.setCode("hello");
		return rt;
	}
	static String guid;
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}
