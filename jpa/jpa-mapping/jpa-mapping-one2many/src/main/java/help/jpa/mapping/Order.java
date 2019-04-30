package help.jpa.mapping;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="ORDR")
public class Order
{
   	@Id
   	@Column(name="id")
   	protected Integer id;
	public Integer getId() {return this.id;}
	public void setId(Integer value) {this.id = value;}



	@Column(name="memo")
   	protected String memo;
   	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="order")
    Collection<OrderDetail> detail;
	public Collection<OrderDetail> getDetail() {
		if(detail==null)
		{
			detail = new ArrayList<>();
		}
		return detail;
	}
	public void setDetail(Collection<OrderDetail> detail) {
		this.detail = detail;
	}

}