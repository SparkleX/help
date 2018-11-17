package help;


import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureBefore(ServletWebServerFactoryAutoConfiguration.class)
public class ForceNettyAutoConfiguration 
{

    @Bean
    NettyReactiveWebServerFactory netty() 
    {
         return new NettyReactiveWebServerFactory();
    }
}