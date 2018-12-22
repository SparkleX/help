package help;

import java.util.HashMap;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name="ServiceA",url="${url}", configuration=FeignSharedConfig.class)
public interface ServiceA// extends ServiceBase<String>
{
	@RequestMapping(method = RequestMethod.GET, value = "/test")
	HashMap<String,Object> call();
}
