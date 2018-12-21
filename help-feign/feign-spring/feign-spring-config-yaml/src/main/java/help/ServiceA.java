package help;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name="ServiceA",url="${url}", configuration=FeignSharedConfig.class)
public interface ServiceA
{
	@RequestMapping(method = RequestMethod.GET, value = "/test1")
	String call(String type);
}
