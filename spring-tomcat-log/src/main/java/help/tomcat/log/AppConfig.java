package help.tomcat.log;

import javax.servlet.Filter;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch.qos.logback.access.tomcat.LogbackValve;

@Configuration
public class AppConfig
{
	@Bean(name = "TeeFilter")
	public Filter teeFilter() {
	    return new ch.qos.logback.access.servlet.TeeFilter();
	}
	@Bean
	public TomcatServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();

	    // put logback-access.xml in src/main/resources/conf
	    tomcat.addContextValves(new LogbackValve());

	    return tomcat;
	}
}
