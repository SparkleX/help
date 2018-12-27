package help;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.mockserver.configuration.ConfigurationProperties;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Header;

public class TestMockServer 
{
	public static void main(String[] argv) throws Exception 
	{
		String login = FileUtils.readFileToString(new File("C:\\Users\\i031684\\Documents\\GitHub\\help\\mock\\mock-http-server\\src\\main\\java\\help\\login.json"));
		String preview = FileUtils.readFileToString(new File("C:\\Users\\i031684\\Documents\\GitHub\\help\\mock\\mock-http-server\\src\\main\\java\\help\\preview.json"));
		ConfigurationProperties.overrideLogLevel("ERROR");
		
		ClientAndServer mockServer = ClientAndServer.startClientAndServer(443);
		
		
		mockServer.when(request().withSecure(true).withMethod("POST").withPath("/b1s/v1/Login"))
				.respond(response().withStatusCode(200)
						.withHeaders(new Header("Content-Type", "application/json; charset=utf-8"),
								new Header("Cache-Control", "public, max-age=86400"),
								new Header("Set-Cookie", "c=d;Path=/;")
								)
						.withBody(login));
		
		mockServer.when(request().withSecure(true).withMethod("POST").withPath("/b1s/v1/OrdersService_Preview"))
				.respond(response().withStatusCode(200)
						.withHeaders(new Header("Content-Type", "application/json; charset=utf-8"),
								new Header("Cache-Control", "public, max-age=86400"))
						.withBody(preview));

	}
}