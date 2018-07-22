package help.spring.multicontext;

import app1.App1;
import app2.App2;

public class App 
{
	public static void main(String[] args) 
	{
		System.setProperty("spring.config.name", "app1");
		App1.main(args);
		System.setProperty("spring.config.name", "app2");
		App2.main(args);

	}
}