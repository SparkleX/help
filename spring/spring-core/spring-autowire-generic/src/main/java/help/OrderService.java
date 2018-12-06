package help;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderService extends ServiceBase<BoOrder>
{
	@RequestMapping(path="/test")
	String test()
	{
		return this.businessObject.getClass().getSimpleName();
	}
}
