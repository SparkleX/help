package help.jpa.mapping;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name="RDR12")
public class OrderTax implements Serializable
{
	private static final long serialVersionUID = 7750054539220410768L;
	@Column(name="tax_id")
	String taxId;
 
   	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	@Id
   	@OneToOne
   	@JoinColumn(name="order_id")
	@JsonBackReference
   	Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
   	
}
