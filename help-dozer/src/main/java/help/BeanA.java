package help;

public class BeanA 
{
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	protected String code;
	protected String name;
	public BeanType getType() {
		return type;
	}
	public void setType(BeanType type) {
		this.type = type;
	}
	protected BeanType type;
}
