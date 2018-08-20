package help;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;


@SpringBootApplication
public class App 
{
	public static void main(String[] args) throws IOException 
	{
		ApplicationContext context = SpringApplication.run(App.class, args);
		try
		{
			tryRead("classpath:res1.txt");
			tryRead("classpath:res_provider.txt");
		}finally
		{
			SpringApplication.exit(context, () -> 0);
		}
	}

	private static void tryRead(String fileName) throws IOException
	{
		URL u = ResourceUtils.getURL(fileName);
		System.out.println(u);
		String s = IOUtils.toString(u.openStream(), "utf8");
		System.out.println(s);
		/*File f = ResourceUtils.getFile(fileName);
		System.out.println(f);
		s  = FileUtils.readFileToString(f,"utf8");
		System.out.println(s);*/

		
	}
}