package help.jpa.mapping;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="ORDR")
public class Order implements Serializable
{
   	/**
	 * 
	 */
	private static final long serialVersionUID = -1371919896868698815L;
	@Id
   	@Column(name="id")
   	protected Integer id;
	public Integer getId() {return this.id;}
	public void setId(Integer value) {this.id = value;}

   	@Column(name="id2")
   	protected Integer id2;
	public Integer getId2() {return this.id2;}
	public void setId2(Integer value) {this.id2 = value;}
/*	@OneToOne(mappedBy="order")
    OrderTax tax;
	public OrderTax getTax() {
		return tax;
	}
	public void setTax(OrderTax tax) {
		this.tax = tax;
	}*/
}