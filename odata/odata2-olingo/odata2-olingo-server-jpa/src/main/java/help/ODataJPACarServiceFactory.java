package help;

import javax.persistence.EntityManagerFactory;

import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAServiceFactory;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPARuntimeException;


public class ODataJPACarServiceFactory extends ODataJPAServiceFactory {

	private static final int PAGE_SIZE = 5;

	private EntityManagerFactory emf;
	public ODataJPACarServiceFactory(EntityManagerFactory emf)
	{
		this.emf = emf;
	}

	@Override
	public ODataJPAContext initializeODataJPAContext()
			throws ODataJPARuntimeException {
		ODataJPAContext oDataJPAContext = getODataJPAContext();
		oDataJPAContext.setEntityManagerFactory(emf);
		oDataJPAContext.setPersistenceUnitName("default");

		oDataJPAContext.setPageSize(PAGE_SIZE);
		setDetailErrors(true);

		return oDataJPAContext;
	}

}
