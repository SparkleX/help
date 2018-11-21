package help;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name="name",url="${url}")
public interface ServiceB// extends ServiceBase<String>
{
	@RequestMapping(method = RequestMethod.GET, value = "/test1")
	String call(String type);
}
