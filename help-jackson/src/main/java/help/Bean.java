package help;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Bean 
{
	@JsonProperty
	public String id;
	
	 
	public void setItems(Map<String, Object> items) {
		this.items = items;
	}

	private Map<String,Object> items;
	
	@JsonAnyGetter
	public Map<String, Object> getItems() {
		return items;
	}

	@JsonAnySetter
    protected void add(String key, Object value) 
	{
		if(items==null) items = new HashMap<>();
        this.items.put(key, value);
    }
}
