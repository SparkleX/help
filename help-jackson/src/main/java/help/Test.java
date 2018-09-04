package help;

import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

	public static void main(String[] args) throws IOException 
	{
		Bean bean = new Bean();
		bean.id = "100";
		ObjectMapper  om = new ObjectMapper ();
		HashMap<String, Object> items = new HashMap<String, Object>();
		items.put("a", 1);
		bean.setItems(items);
		String str = om.writeValueAsString(bean);
		System.out.println(str);
		
		Bean beanInput = om.readValue("{\"id\":\"100\",\"a\":1}", Bean.class);
		System.out.println(beanInput.getItems().get("a"));		

	}

}
