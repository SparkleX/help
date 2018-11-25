package help;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableAsync
@Component
public class Application 
{
	@Autowired
    private AsyncTestService asyncTask;
	
	public static void main(String[]argc)
	{
		ApplicationContext appCtx = SpringApplication.run(Application.class, argc);
		Application app = appCtx.getBean(Application.class);
		app.test();
	}
	private void test() 
	{
		asyncTask.asyncMethod();
		System.out.println("hello");
		asyncTask.testAsync();
		System.out.println("finish sync");
		
	}
}
