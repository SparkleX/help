package help;

import feign.Contract;
import feign.Contract.Default;
import feign.Feign;
import feign.Feign.Builder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public class App {

	public static void main(String[] args) 
	{
		Builder feign = Feign.builder();
		Default feignContract = new MyContract();
		//feign.encoder(new JacksonEncoder());
		//feign.decoder(new JacksonDecoder());
        feign.contract(feignContract);      
		ServiceA service = feign.target(ServiceA.class, "http://sports.sina.com.cn");
		
		String str = service.call("china/j/2018-11-21/doc-ihmutuec2376408.shtml");
		System.out.println(str);

	}

}
