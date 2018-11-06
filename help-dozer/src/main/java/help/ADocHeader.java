package help;

import java.util.List;

public class ADocHeader 
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
	
	public List<ADocLine> getLines() {
		return lines;
	}
	public void setLines(List<ADocLine> lines) {
		this.lines = lines;
	}
	protected List<ADocLine> lines;
}
