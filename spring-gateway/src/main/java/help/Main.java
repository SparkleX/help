package help;

import app1.App1;
import app2.App2;
import help.spring.gateway.Gateway;

public class Main {

	public static void main(String[] args) 
	{
		System.setProperty("spring.config.name", "gateway");
		Gateway.main(args);
		System.setProperty("spring.config.name", "app1");
		App1.main(args);
		System.setProperty("spring.config.name", "app2");
		App2.main(args);
	}

}
