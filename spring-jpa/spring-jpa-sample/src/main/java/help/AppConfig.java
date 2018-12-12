package help;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig 
{
	@Bean
	DataSource dataSource() throws ClassNotFoundException
	{
		return new MyDataSource();
	}
}
