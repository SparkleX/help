package help.spring.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@SpringCloudApplication
public class APIGatewayApplication  
{

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/test1/**")
                        .uri("http://localhost:8081")
                )
                .route(r -> r.path("/test2/**")
                        .uri("http://localhost:8082")
                )
                .build();
    }

    public static void main(String[] args) 
    {
        SpringApplication.run(APIGatewayApplication.class, args);
    }

}