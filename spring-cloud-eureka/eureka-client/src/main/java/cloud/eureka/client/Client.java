package cloud.eureka.client;

import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name="service1")
public interface Client 
{
    @RequestMapping(method = RequestMethod.GET, value = "/test1")
    ClientBean test();
}