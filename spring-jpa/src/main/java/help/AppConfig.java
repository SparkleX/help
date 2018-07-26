package help;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
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
	
	
	@Bean("entityManagerFactory")
	public EntityManagerFactory createEntityManager(DataSource dataSource)
	{
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);

		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setGenerateDdl(true);
		jpaVendorAdapter.setShowSql(true);

		em.setPackagesToScan("help");
		em.setJpaVendorAdapter(jpaVendorAdapter);
		em.afterPropertiesSet();
		return em.getObject();
	}
	
	
    @Bean("transactionManager")
    public PlatformTransactionManager txManager(DataSource dataSource) {
       // return new DataSourceTransactionManager(dataSource);
    	return new JpaTransactionManager();
    }
}
