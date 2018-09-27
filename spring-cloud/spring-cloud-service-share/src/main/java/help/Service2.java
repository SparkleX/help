package help;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="service2")
public interface Service2 
{
	@RequestMapping("/hello")
	String hello(@RequestParam("str") String str);
}
