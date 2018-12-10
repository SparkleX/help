package help;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application 
{
	@Autowired
	private ResourceLoader resourceLoader;
	
	@RequestMapping(path="/test")
	String test() throws IOException
	{
		InputStream is = resourceLoader.getResource("classpath:/1.txt").getInputStream();
		String msg = StreamUtils.copyToString(is, Charset.defaultCharset());
		return msg;
	}
	
	@RequestMapping(path="/list")
	String list() throws IOException
	{
		Resource[] rs = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources("classpath:*.txt");
		return Integer.toString(rs.length);
	}
	
	static public void main(String [] args)
	{
		SpringApplication.run(Application.class, args);
	}
}
