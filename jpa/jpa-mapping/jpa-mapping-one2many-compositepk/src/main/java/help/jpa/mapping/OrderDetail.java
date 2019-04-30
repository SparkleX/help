package help.jpa.mapping;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name="RDR1")
@IdClass(OrderDetailKey.class)
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

	@Id
	@Column(name="line_num")
	Integer lineNum;

	public Integer getLineNum() {
		return lineNum;
	}

	public void setLineNum(Integer lineNum) {
		this.lineNum = lineNum;
	}

   	@ManyToOne(fetch=FetchType.LAZY)
   	@JoinColumn(name="id",insertable=false, updatable=false)
	@JsonBackReference
   	Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
   	
}
