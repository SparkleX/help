package help;

public class JsonNode
{
	public String getValue()
	{
		return value;
	}
	public void setValue(String value)
	{
		this.value = value;
	}
	public String getDesc()
	{
		return desc;
	}
	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	String value;
	String desc;
	
	public String toString()
	{
		return "1:123";
	}
}
