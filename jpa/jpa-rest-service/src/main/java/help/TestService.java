package help;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import help.model.SalesOrder;

@RestController
public class TestService 
{
	@Autowired
	OrderService orderService;
	
	
	
	@GetMapping(path="/test")
	public List<SalesOrder> test()
	{
		return orderService.test();
	}
	
	
	@GetMapping(path="/init")
	public String init()
	{
		return orderService.init();
	}
}
