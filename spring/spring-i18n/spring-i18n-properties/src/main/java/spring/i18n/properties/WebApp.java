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
    private MessageSource messageSource;

    
	@RequestMapping("/test")
	public String test()
	{
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("welcome",null, "(---)",locale);
	}
	public static void main(String[] args) {
		SpringApplication.run(WebApp.class, args);
	}

}
