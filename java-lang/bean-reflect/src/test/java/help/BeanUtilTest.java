package help;

import static org.junit.Assert.assertEquals;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;

public class BeanUtilTest {

	@Test
	public void describProperty() throws IntrospectionException 
	{
		BeanInfo info = Introspector.getBeanInfo(Student.class);
		PropertyDescriptor[] pds = info.getPropertyDescriptors();
		for(PropertyDescriptor pd:pds)
		{
			System.out.println(pd.getName());
		}
		
	}
	@Test
	public void beanToMap() throws Exception 
	{
		Student s = new Student();
		s.setID("ID");
		Map<String,Object> m = PropertyUtils.describe(s);
		System.out.println(m.toString());
		assertEquals(s.getID(), m.get("ID"));
	}
	
	@Test
	public void mapToBean() throws Exception 
	{
		Student s = new Student();
		HashMap<String,String> map = new HashMap<>();
		map.put("ID", "123");
		BeanUtils.populate(s, map);
		assertEquals(map.get("ID"),s.getID());
		
	}
	@Test
	public void testDecapitalize() throws IntrospectionException 
	{
		assertEquals("WTCode", Introspector.decapitalize("WTCode"));
		assertEquals("firstName", Introspector.decapitalize("FirstName"));
		assertEquals("firstName", Introspector.decapitalize("firstName"));
	}

	
}
