package help;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.transaction.jta.JtaTransactionManager;

import help.jpa.QuickJpaVendorAdapter;

@Configuration
public class JpaConfig extends JpaBaseConfiguration { 
 
    protected JpaConfig(DataSource dataSource, JpaProperties properties,
			ObjectProvider<JtaTransactionManager> jtaTransactionManager,
			ObjectProvider<TransactionManagerCustomizers> transactionManagerCustomizers) {
		super(dataSource, properties, jtaTransactionManager, transactionManagerCustomizers);
	}

	@Override
    protected AbstractJpaVendorAdapter createJpaVendorAdapter() { 
        return new QuickJpaVendorAdapter(); 
    }
	@Override
	protected Map<String, Object> getVendorProperties() {
	    HashMap<String, Object> map = new HashMap<>();
	    return map;
	}
}