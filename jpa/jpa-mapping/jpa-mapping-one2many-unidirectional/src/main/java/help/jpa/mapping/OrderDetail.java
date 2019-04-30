package help.jpa.mapping;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="RDR1")
public class OrderDetail implements Serializable
{
	private static final long serialVersionUID = 7750054539220410768L;

	@Id
   	@Column(name="id")
	Integer id;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="line_num")
	Integer lineNum;

	public Integer getLineNum() {
		return lineNum;
	}

	public void setLineNum(Integer lineNum) {
		this.lineNum = lineNum;
	}

	@Column(name="order_id")
	Integer orderId;
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

   	
}
