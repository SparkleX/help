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


	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/*public SalesOrder getDocId() {
		return docId;
	}

	public void setDocId(SalesOrder docId) {
		this.docId = docId;
	}*/

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	/*public SalesOrder getDoc() {
		return doc;
	}

	public void setDoc(SalesOrder doc) {
		this.doc = doc;
	}*/

	public Integer getDocId() {
		return docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public void setLineNum(Integer lineNum) {
		this.lineNum = lineNum;
	}

	@ManyToOne(optional = false,fetch=FetchType.LAZY)
	@JoinColumn(name="DocId", insertable = false, updatable = false)
	SalesOrder doc;

	@Id
	@Column(name="DocId")
	@JoinColumn(name="DocId", referencedColumnName="Id",table="ORDR")
	Integer docId;
	
	@Id
	@Column(name="LineNum")
	Integer lineNum;
	
	
	@ManyToOne(optional = false,fetch=FetchType.EAGER)
	@JoinColumn(name="ItemId",insertable = false, updatable = false)
	@JsonIdentityReference(alwaysAsId = true)
	Item item;
	
	@Column(name="Price", precision = 30, scale = 5)
	BigDecimal price;
	
	@Column(name = "ItemId")
	Integer itemId;
	
}
