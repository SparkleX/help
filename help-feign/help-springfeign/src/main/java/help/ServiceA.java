package help;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name="test",url="http://www.sina.com.cn")
public interface ServiceA extends ServiceBase<String>
{
	@RequestMapping(method = RequestMethod.GET, value = "/test1")
	String call(String type);
}
