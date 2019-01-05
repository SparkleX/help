package help.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import help.EntityIdResolver;

@Entity
@Table(name = "OITM")
@JsonIdentityInfo(
		property = "id",
		generator = ObjectIdGenerators.PropertyGenerator.class,
		resolver = EntityIdResolver.class,
		scope=Item.class)
public class Item 
{
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getItemCode() {
		return itemCode;
	}


	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id")
	Integer id;

	@Column(name="ItemCode")
	protected String itemCode;
	
	
	@Column(name="ItemName")
	protected String itemName;

}
