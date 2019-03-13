package help;

import java.util.List;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.WebSession;

import reactor.core.publisher.Mono;


@Component
public class JwtResponseFilter extends AbstractGatewayFilterFactory<String>
{
	public JwtResponseFilter() 
	{
		super(String.class);
	}
	@Override
	public GatewayFilter apply(String config) 
	{
		return (exchange, chain) -> 
		{
		exchange.getResponse().beforeCommit(() -> {
			List<String> headers = exchange.getResponse().getHeaders().get("WWW-Authenticate");
			if (headers != null) {
				String token = headers.get(0);
				WebSession session = exchange.getSession().block();
				session.getAttributes().put("jwt_token", token);
				exchange.getResponse().getHeaders().remove("WWW-Authenticate");
			}
			return Mono.empty();
		});

		return chain.filter(exchange);
		};
	}
}

/*@Component
public class JwtResponseFilter implements WebFilter {
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
		exchange.getResponse().beforeCommit(() -> {
			List<String> headers = exchange.getResponse().getHeaders().get("WWW-Authenticate");
			if (headers != null) {
				String token = headers.get(0);
				WebSession session = exchange.getSession().block();
				session.getAttributes().put("jwt_token", token);
			}
			return Mono.empty();
		});

		return chain.filter(exchange);
	}
}*/