package app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.cloud.gateway.config.GatewayAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;



@SpringBootApplication
@EnableMBeanExport(defaultDomain="app1")
//@EnableAutoConfiguration(exclude={GatewayAutoConfiguration.class})
@Configuration
public class App1 
{

	public static void main(String[] args) 
	{
		System.setProperty("spring.config.name", "app1");
		//System.setProperty("server.servlet.context-path", "/app1");
		SpringApplication.run(App1.class, args);
	}
}