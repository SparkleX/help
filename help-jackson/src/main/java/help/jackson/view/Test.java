package help.jackson.view;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Test {
	public static void main(String []argc) throws JsonProcessingException
	{
		Bean o = new Bean();
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
		ObjectWriter ow = mapper.writerWithView(Views.A.class);
		//mapper.writerWithView(Views.A.class);
		
		String out = ow.writeValueAsString(o);
		
		System.out.println(out);

	}
}
