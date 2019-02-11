package help;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.transaction.jta.JtaTransactionManager;

import help.jpa.QkJpaVendorAdapter;



@Configuration
public class JpaConfig extends JpaBaseConfiguration 
{ 
    JpaConfig(DataSource dataSource, JpaProperties properties,
			ObjectProvider<JtaTransactionManager> jtaTransactionManager,
			ObjectProvider<TransactionManagerCustomizers> transactionManagerCustomizers) {
		super(dataSource, properties, jtaTransactionManager, transactionManagerCustomizers);
	}
   
	@Override
    protected AbstractJpaVendorAdapter createJpaVendorAdapter() 
    { 
        return new QkJpaVendorAdapter(); 
    }
	@Override
	protected Map<String, Object> getVendorProperties() {
	    HashMap<String, Object> map = new HashMap<>();
	    map.put(PersistenceUnitProperties.WEAVING, "false");
	    map.put(PersistenceUnitProperties.DDL_GENERATION, "drop-and-create-tables");
	    return map;
	}
	/*@Bean
	public InstrumentationLoadTimeWeaver loadTimeWeaver()  throws Throwable {
	    InstrumentationLoadTimeWeaver loadTimeWeaver = new InstrumentationLoadTimeWeaver();
	    return loadTimeWeaver;
	}*/
}
