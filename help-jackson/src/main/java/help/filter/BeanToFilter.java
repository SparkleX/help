package help.filter;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BeanToFilter 
{
	@IgnoreLevel("1")	
	@JsonProperty
	public String id;
	
	
	@IgnoreLevel("2")	
	@JsonProperty
	public String id2;
}
