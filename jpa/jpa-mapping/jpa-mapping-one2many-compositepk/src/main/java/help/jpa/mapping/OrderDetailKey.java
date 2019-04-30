package help.jpa.mapping;

import java.io.Serializable;

public class OrderDetailKey implements Serializable
{
	private static final long serialVersionUID = 4387555708642302456L;

	public Integer getLineNum() {
		return lineNum;
	}

	public void setLineNum(Integer lineNum) {
		this.lineNum = lineNum;
	}



	Integer lineNum;
	
   	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	Integer id;
}
