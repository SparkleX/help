package help.model;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

@Entity
@Table(name = "RDR1")
@IdClass(SalesOrderDetailKey.class)
public class SalesOrderDetail 
{

	public int getLineNum() {
		return lineNum;
	}

	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}

	public Item getItemId() {
		return itemId;
	}

	public void setItemId(Item itemId) {
		this.itemId = itemId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public SalesOrder getDocId() {
		return docId;
	}

	public void setDocId(SalesOrder docId) {
		this.docId = docId;
	}

	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="doc_id", referencedColumnName="id",nullable=false)
	@JsonIdentityReference(alwaysAsId = true)
	SalesOrder docId;
	
	@Id
	int lineNum;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="item_id")
	@JsonIdentityReference(alwaysAsId = true)
	Item itemId;
	
	@Column
	BigDecimal price;
	

	
}
