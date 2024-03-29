package help.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class AppConfig 
{
	@Bean()
	DataSource dataSource() throws Exception
	{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setMaxPoolSize(100);
		cpds.setJdbcUrl("jdbc:sqlserver://vspk:1433;databaseName=test;user=sa;password=12345678");
		cpds.getConnection().close();
		return cpds;
	}
	
    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
