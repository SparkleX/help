package help.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*@Entity
@Table(name = "RDR1")
@IdClass(OrderDetailsKey.class)
public class OrderDetails
{
	public Integer getDocEntry()
	{
		return docEntry;
	}

	public void setDocEntry(Integer docEntry)
	{
		this.docEntry = docEntry;
	}

	public Integer getLineNum()
	{
		return lineNum;
	}

	public void setLineNum(Integer lineNum)
	{
		this.lineNum = lineNum;
	}

	public BigDecimal getPrice()
	{
		return price;
	}

	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}

	@Id
	@Column
	Integer docEntry;

	@Id
	@Column
	Integer lineNum;
	
	@Column
	BigDecimal price;
	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "docEntry", insertable = false, updatable = false)
	Order order;
}*/
