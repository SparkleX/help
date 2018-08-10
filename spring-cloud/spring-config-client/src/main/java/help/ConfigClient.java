package help;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class ConfigClient 
{
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient.class, args);
    }
    @Value("${test.user}")
    String user;
    @Value("${test.password}")
    String password;

    @RequestMapping("/test")
    public String test()
    {
        return user+password;
    }
}