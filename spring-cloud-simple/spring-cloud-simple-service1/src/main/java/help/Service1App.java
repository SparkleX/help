package help;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class Service1App {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Service1App.class, args);
	}

}
