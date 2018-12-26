package help.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/*@Entity
@Table(name = "ORDR")
public class Order
{
	public Integer getDocEntry()
	{
		return docEntry;
	}

	public void setDocEntry(Integer docEntry)
	{
		this.docEntry = docEntry;
	}





	@Id
	@Column
	@GeneratedValue
	Integer docEntry;
	
//	@OneToMany(mappedBy = "docEntry", fetch = FetchType.LAZY)
//	Collection<OrderDetails> details;
	
//	@Column
//	String cardCode;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "\"CardCode\"", insertable = false, updatable = false)
	OCRD cardCode;

	public OCRD getCardCode()
	{
		return cardCode;
	}

	public void setCardCode(OCRD cardCode)
	{
		this.cardCode = cardCode;
	}
	

	
	//List<OrderDetails> details;
}*/
