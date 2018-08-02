package help.client.openfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.feign.EnableFeignClients;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

@SpringBootApplication
//@EnableFeignClients
public class Application {

    public static void main(String[] args) 
    {
    	Client bookClient = Feign.builder()
    			  .client(new OkHttpClient())
    			  .encoder(new GsonEncoder())
    			  .decoder(new GsonDecoder())
    			  .logger(new Slf4jLogger(Client.class))
    			  //.logLevel(Logger.Level.FULL)
    			  .target(Client.class, "http://localhost:8080");
    	ClientBean bean = bookClient.test();
    	System.out.println(bean.getCode());
       // SpringApplication.run(Application.class, args);
    }

}