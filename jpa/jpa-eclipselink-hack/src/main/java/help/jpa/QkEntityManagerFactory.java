package help.jpa;

import java.util.Map;

import org.eclipse.persistence.internal.jpa.EntityManagerFactoryImpl;
import org.eclipse.persistence.internal.jpa.EntityManagerSetupImpl;

public class QkEntityManagerFactory extends EntityManagerFactoryImpl
{
	public QkEntityManagerFactory(EntityManagerSetupImpl setupImpl, Map properties) {
		super(setupImpl, properties);
	}
}
