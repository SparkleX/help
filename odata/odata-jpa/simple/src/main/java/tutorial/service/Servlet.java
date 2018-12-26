
package tutorial.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.olingo.commons.api.ex.ODataException;
import com.sap.olingo.jpa.metadata.api.JPAEdmProvider;
import com.sap.olingo.jpa.metadata.api.JPAEntityManagerFactory;
import com.sap.olingo.jpa.processor.core.api.JPAODataGetHandler;

import org.apache.olingo.server.api.OData;
import org.apache.olingo.server.api.ODataHttpHandler;
import org.apache.olingo.server.api.ServiceMetadata;
import org.apache.olingo.server.api.processor.EntityProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.olingo.commons.api.edmx.EdmxReference;


@WebServlet(urlPatterns="/test/*")
public class Servlet extends HttpServlet 
{

	@Autowired
	EntityManagerFactory emf;

	private static final long serialVersionUID = 1L;
	private static final String PUNIT_NAME = "test";

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			//EntityManagerFactory emf = JPAEntityManagerFactory.getEntityManagerFactory(PUNIT_NAME, new HashMap<String, Object>());
			
			JPAEdmProvider metadataProvider = new JPAEdmProvider(PUNIT_NAME, emf, null, null);

			OData odata = OData.newInstance();
			//ServiceMetadata edm = odata.createServiceMetadata(metadataProvider, new ArrayList<EdmxReference>());
			//ODataHttpHandler handler = odata.createHandler(edm);
			
			JPAODataGetHandler handler = new JPAODataGetHandler(PUNIT_NAME,emf);
			
			
			
			
			handler.process(req, resp);
		} catch (RuntimeException e) 
		{
			e.printStackTrace();
			throw new ServletException(e);
		} catch (ODataException e) 
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}