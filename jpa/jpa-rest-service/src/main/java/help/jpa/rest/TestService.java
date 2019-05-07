package help.jpa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import help.jpa.rest.model.SalesOrder;

@RestController
public class TestService 
{
	@Autowired
	OrderService orderService;
	
	
	
	@GetMapping(path="/test")
	public SalesOrder test()
	{
		try
		{
			SalesOrder list = orderService.test();
			Integer a = list.getId();
			return list;
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		
	}
	
	
	@GetMapping(path="/init")
	public String init()
	{
		return orderService.init();
	}
	
	@PostMapping(path="/create")
	public String create(@RequestBody SalesOrder data)
	{
		return orderService.create(data);
	}
}
