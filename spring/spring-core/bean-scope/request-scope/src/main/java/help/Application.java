package help;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application 
{
	
	@Autowired
	RequestScopeBean requestBean;
	
	@Autowired
	SingletonScopeBean singletonBean;
	
	@Autowired
	PrototypeBean prototypeBean;
	
	@Autowired
	ThreadScopeBean threadBean;
	
	
	@RequestMapping(path="/testr")
	public String testRequest()
	{
		long from = System.currentTimeMillis();
		int total = 0;
		for(int i =0;i<=10000000;i++)
		{
			total = requestBean.test(total);
		}
		long to = System.currentTimeMillis();
		return String.format("%d, %d", to - from, total);
	}
	
	@RequestMapping(path="/tests")
	public String testSingle()
	{
		long from = System.currentTimeMillis();
		int total = 0;
		for(int i =0;i<=10000000;i++)
		{
			total = singletonBean.test(total);
		}
		long to = System.currentTimeMillis();
		return String.format("%d, %d", to - from, total);
	}
	@RequestMapping(path="/testt")
	public String testThread()
	{
		
		System.out.println(Thread.currentThread());
		System.out.println(threadBean);
		long from = System.currentTimeMillis();
		int total = 0;
		for(int i =0;i<=10000000;i++)
		{
			total = threadBean.test(total);
		}
		long to = System.currentTimeMillis();
		return String.format("%d, %d", to - from, total);
	}
	@RequestMapping(path="/testp")
	public String testPrototype()
	{
		long from = System.currentTimeMillis();
		int total = 0;
		for(int i =0;i<=10000000;i++)
		{
			total = prototypeBean.test(total);
		}
		long to = System.currentTimeMillis();
		return String.format("%d, %d", to - from, total);
	}

	static public void main(String []args)
	{
		SpringApplication.run(Application.class, args);
	}
}
