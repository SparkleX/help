package help;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.apache.olingo.odata2.core.servlet.ODataServlet;


@WebServlet(urlPatterns="/test/*")
public class CatServlet extends ODataServlet 
{
	private static final long serialVersionUID = -4563879895896080797L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
	
		ODataServiceFactory oDataServiceFactory = new CarServiceFactory();
		req.setAttribute("org.apache.olingo.odata2.service.factory.instance", oDataServiceFactory);
		super.service(req, resp);
	}


}
