package help;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import org.mockserver.configuration.ConfigurationProperties;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Header;

public class TestMockServer 
{
	public static void main(String[] argv) 
	{
		ConfigurationProperties.overrideLogLevel("ERROR");
		
		ClientAndServer mockServer = ClientAndServer.startClientAndServer(443);
		
		
		mockServer.when(request().withSecure(true).withMethod("GET").withPath("/test"))
				.respond(response().withStatusCode(200)
						.withHeaders(new Header("Content-Type", "application/json; charset=utf-8"),
								new Header("Cache-Control", "public, max-age=86400"))
						.withBody("{\"a\":1,\"b\":2}"));
		
		mockServer.when(request().withSecure(true).withMethod("GET").withPath("/aaaa"))
				.respond(response().withStatusCode(200)
						.withHeaders(new Header("Content-Type", "application/json; charset=utf-8"),
								new Header("Cache-Control", "public, max-age=86400"))
						.withBody("aaaa"));

	}
}