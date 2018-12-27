package help.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class AppJaxb 
{
	public static void main(String[] args) throws JAXBException 
	{
		 JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
	 
		 Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		 unmarshaller.setProperty("com.sun.xml.bind.ObjectFactory",new ObjectFactoryImpl());
		 Table obj = (Table) unmarshaller.unmarshal(new File("C:\\Users\\sunxufei\\Documents\\GitHub\\help\\xml\\xml-maven-validate\\src\\main\\resources\\xml\\tableTest.xml"));
		 System.out.println(obj.getColumns().size());

	}
}
