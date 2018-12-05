package help.jpa;

import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceProvider;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.persistence.spi.ProviderUtil;

public class QuickPersistenceProvider implements PersistenceProvider {

	@Override
	public EntityManagerFactory createEntityManagerFactory(String emName, Map map) {
		throw new RuntimeException("NOT IMPLEMENTED");
	}

	@Override
	public EntityManagerFactory createContainerEntityManagerFactory(PersistenceUnitInfo info, Map map) {
		// TODO Auto-generated method stub
		return new QuickEntityManagerFactory();
	}

	@Override
	public void generateSchema(PersistenceUnitInfo info, Map map) {
		throw new RuntimeException("NOT IMPLEMENTED");

	}

	@Override
	public boolean generateSchema(String persistenceUnitName, Map map) {
		throw new RuntimeException("NOT IMPLEMENTED");
	}

	@Override
	public ProviderUtil getProviderUtil() {
		throw new RuntimeException("NOT IMPLEMENTED");
	}

}
