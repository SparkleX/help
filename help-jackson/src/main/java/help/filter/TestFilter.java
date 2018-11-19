package help.filter;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestFilter {
	public static void main(String[] args) throws IOException 
	{
		BeanToFilter bean = new BeanToFilter();
		bean.id = "123";
		bean.id2="2";
		ObjectMapper  om = new ObjectMapper ();
		om.registerModule(new MyModule());
		String str = om.writeValueAsString(bean);
		System.out.println(str);
		
		bean = om.readValue("{\"id\":\"1\",\"id2\":\"2\"}",BeanToFilter.class);
		System.out.println(bean.id);
	}

}
