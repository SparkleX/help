package help.jpa;



import javax.persistence.spi.PersistenceProvider;

import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;

public class QkJpaVendorAdapter extends EclipseLinkJpaVendorAdapter 
{

	@Override
	public PersistenceProvider getPersistenceProvider() 
	{
		return new QkPersistenceProvider();
	}
}
