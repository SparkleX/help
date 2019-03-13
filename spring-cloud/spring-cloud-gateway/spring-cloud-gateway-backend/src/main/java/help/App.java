package help;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class App 
{
	@RequestMapping("/test")
	
	public String create(HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("Authentication:" + request.getHeader("Authentication"));
		System.out.println("Cookie:" + request.getHeader("Cookie"));
		response.addHeader("WWW-Authenticate", "a new jwt token here");

		return "test";
	}
	public static void main(String[] args) 
	{
		SpringApplication.run(App.class, args);
	}
}