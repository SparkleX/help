package help;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name="ServiceB",url="${url}", configuration=FeignSharedConfig.class)
public interface ServiceB
{
	@RequestMapping(method = RequestMethod.GET, value = "/test1")
	String call(String type);
}
