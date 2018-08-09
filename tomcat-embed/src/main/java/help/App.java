package help;

import java.io.File;

import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App 
{
    public static void main( String[] args ) throws LifecycleException, ServletException
    {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        new File(tomcat.getServer().getCatalinaBase(), "webapps").mkdirs();
        String wars = new File("war").getAbsolutePath();
        
        tomcat.addWebapp("/web", wars + "/web.war");
        tomcat.start();
        tomcat.getServer().await();
    }
}
