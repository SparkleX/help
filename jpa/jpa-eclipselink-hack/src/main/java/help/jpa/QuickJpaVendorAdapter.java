package help.jpa;



import javax.persistence.spi.PersistenceProvider;

import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;

public class QuickJpaVendorAdapter extends AbstractJpaVendorAdapter 
{
	public QuickJpaVendorAdapter()
	{
		
	}

	@Override
	public PersistenceProvider getPersistenceProvider() 
	{
		return new QuickPersistenceProvider();
	}
}
