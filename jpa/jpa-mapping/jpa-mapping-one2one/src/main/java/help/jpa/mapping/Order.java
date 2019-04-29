package help.jpa.mapping;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="ORDR")
public class Order
{
   	@Id
   	@Column(name="id")
   	protected Integer id;
	public Integer getId() {return this.id;}
	public void setId(Integer value) {this.id = value;}

	@OneToOne(mappedBy="order")
    OrderTax tax;
	public OrderTax getTax() {
		return tax;
	}
	public void setTax(OrderTax tax) {
		this.tax = tax;
	}
}