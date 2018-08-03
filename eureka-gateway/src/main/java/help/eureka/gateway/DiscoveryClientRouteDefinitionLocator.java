package help.eureka.gateway;

import static org.springframework.cloud.gateway.handler.predicate.RoutePredicateFactory.PATTERN_KEY;

import java.net.URI;
import java.util.List;
import java.util.function.Function;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;

import reactor.core.publisher.Flux;

public class DiscoveryClientRouteDefinitionLocator implements RouteDefinitionLocator {

	private final DiscoveryClient discoveryClient;

	public DiscoveryClientRouteDefinitionLocator(DiscoveryClient discoveryClient) {
		this.discoveryClient = discoveryClient;
	}

	@Override
	public Flux<RouteDefinition> getRouteDefinitions() 
	{
		List<String> services = discoveryClient.getServices();
		Flux<String> a = Flux.fromIterable(services);
		Function<String,RouteDefinition> mapper = new Function<String,RouteDefinition>()
		{
			@Override
			public RouteDefinition apply(String serviceId) 
			{
				RouteDefinition routeDefinition = new RouteDefinition();
				routeDefinition.setId(serviceId);
				URI uri = URI.create("lb://" + serviceId);
				routeDefinition.setUri(uri);

				PredicateDefinition subPredicate = new PredicateDefinition();
				subPredicate.setName("Path");//normalizePredicateName(PathRoutePredicateFactory.class));
				subPredicate.addArg(PATTERN_KEY, "/"+serviceId.toLowerCase()+"/**");
				routeDefinition.getPredicates().add(subPredicate);

				/*FilterDefinition filter = new FilterDefinition();
				filter.setName(normalizeFilterName(RewritePathGatewayFilterFactory.class));
				String regex = "/" + serviceId + "/(?<remaining>.*)";
				String replacement = "/${remaining}";
				filter.addArg(REGEXP_KEY, regex);
				filter.addArg(REPLACEMENT_KEY, replacement);
				routeDefinition.getFilters().add(filter);*/
				return routeDefinition;
			}
			
		};
		return a.map(mapper);
		
	/*	return Flux.fromIterable(discoveryClient.getServices()).map(serviceId -> {
			RouteDefinition routeDefinition = new RouteDefinition();
			routeDefinition.setId(this.routeIdPrefix + serviceId);
			routeDefinition.setUri(URI.create("lb://" + serviceId));

			PredicateDefinition subPredicate = new PredicateDefinition();
			subPredicate.setName(normalizePredicateName(PathRoutePredicateFactory.class));
			subPredicate.addArg(PATTERN_KEY, "/" + serviceId + "/**");
			routeDefinition.getPredicates().add(subPredicate);

			FilterDefinition filter = new FilterDefinition();
			filter.setName(normalizeFilterName(RewritePathGatewayFilterFactory.class));
			String regex = "/" + serviceId + "/(?<remaining>.*)";
			String replacement = "/${remaining}";
			filter.addArg(REGEXP_KEY, regex);
			filter.addArg(REPLACEMENT_KEY, replacement);
			routeDefinition.getFilters().add(filter);

			// TODO: support for default filters

			return routeDefinition;
		});*/
	}
}