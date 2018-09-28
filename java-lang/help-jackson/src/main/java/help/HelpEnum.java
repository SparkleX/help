package help;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HelpEnum
{

	public static void main(String[] args) throws JsonProcessingException
	{
        ObjectMapper om = new ObjectMapper();
        Customer value = new Customer();
        String json = om.writeValueAsString(value);
        System.out.println(json);	

	}

}
