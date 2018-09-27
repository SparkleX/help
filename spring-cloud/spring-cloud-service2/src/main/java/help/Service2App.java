package help;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class Service2App {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Service2App.class, args);
	}

}
