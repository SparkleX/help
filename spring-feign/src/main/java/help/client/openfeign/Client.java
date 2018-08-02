package help.client.openfeign;

//import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import feign.RequestLine;

//@FeignClient("stores")
public interface Client 
{
    //@RequestMapping(method = RequestMethod.GET, value = "/test")
	@RequestLine("GET /test")
    ClientBean test();
}