package help.zipin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import zipkin.server.EnableZipkinServer;



@EnableDiscoveryClient
@EnableZipkinServer
@SpringBootApplication
//@EnableZipkinStreamServer
public class ZipkinServerApp {
	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApp.class, args);
	}
}
