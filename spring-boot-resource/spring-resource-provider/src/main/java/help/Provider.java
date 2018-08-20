package help;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.util.ResourceUtils;

public class Provider
{
	public static void tryRead(String fileName) throws IOException
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
