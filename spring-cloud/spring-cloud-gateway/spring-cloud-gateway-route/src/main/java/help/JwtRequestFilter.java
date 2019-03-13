package help;

import java.time.Duration;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.WebSession;
@Component
public class JwtRequestFilter extends AbstractGatewayFilterFactory<JwtRequestFilter.SomeConfig> 
{
	private String jwtToken = "jwt_token";

	public JwtRequestFilter() 
	{
		super(JwtRequestFilter.SomeConfig.class);
	}
	@Override
	public GatewayFilter apply(JwtRequestFilter.SomeConfig config) 
	{
		return (exchange, chain) -> 
		{
			ServerHttpRequest request = exchange.getRequest();
			WebSession session = exchange.getSession().block();
			Duration timeout = Duration.ofSeconds(2);
			session.setMaxIdleTime(timeout);
			System.out.println("Session ID:" + session.getId());
			Object value = session.getAttributes().get(jwtToken);
			
			if(value==null)
			{
				System.out.println("Session jwt_token null");
				session.getAttributes().put(jwtToken,"123");
			}
			if(value!=null)
			{
				request = request.mutate().header("Authentication","Bearer " + value).build();
				return chain.filter(exchange.mutate().request(request).build());
			}
			return chain.filter(exchange);
		};
	}

	public static class SomeConfig 
	{

	}

}