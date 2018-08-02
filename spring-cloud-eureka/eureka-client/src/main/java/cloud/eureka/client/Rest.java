package cloud.eureka.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class Rest 
{
	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;
	
	@RequestMapping("/test")
	public String test()
	{
		String url = "http://SERVICE1/test";
		String data = restTemplate.getForObject(url, String.class);
		return data;
	}
	
	@Autowired
	Client client;
	@RequestMapping("/test1")
	public String test1()
	{
		ClientBean bean = client.test();
		return bean.getCode();
	}
}
