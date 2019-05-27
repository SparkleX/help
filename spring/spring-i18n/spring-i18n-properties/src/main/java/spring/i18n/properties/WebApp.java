package spring.i18n.properties;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WebApp {

    @Autowired
    private MessageUtil messageSource;

    
	@RequestMapping("/test")
	public String test()
	{
		long from = System.currentTimeMillis();
		/*for(int i =100000;i<=110000;i++)
		{
			messageSource.getMessage("string"+i);
		}*/
		long to = System.currentTimeMillis();
		System.out.println(to-from);
		return messageSource.getMessage("wel.come");
	}
	public static void main(String[] args) {
		SpringApplication.run(WebApp.class, args);
	}

}
