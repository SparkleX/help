package help.eureka.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableDiscoveryClient
public class GatewaySampleApplication {


    @Bean
    public RouteDefinitionLocator discoveryClientRouteDefinitionLocator(DiscoveryClient discoveryClient) 
    {
        return new DiscoveryClientRouteDefinitionLocator(discoveryClient);
    }
    
    public static void main(String[] args) 
    {
    	//System.setProperty("eureka.instance.instance-id","gateway");
        SpringApplication.run(GatewaySampleApplication.class, args);
    }
}


