package help.jpa.mapping;

import java.io.Serializable;

public class OrderDetailKey implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4387555708642302456L;

	public Integer getLineNum() {
		return lineNum;
	}

	public void setLineNum(Integer lineNum) {
		this.lineNum = lineNum;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	Integer lineNum;
	
   	Order order;
}
