package help;

import java.util.List;

public class BDocHeader extends BDocBase
{
	public String getCodeB() {
		return codeB;
	}
	public void setCodeB(String codeB) {
		this.codeB = codeB;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	String codeB;
	String name;
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	Integer type;


}
