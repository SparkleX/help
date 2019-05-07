package help.jpa.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import help.jpa.rest.EntityIdResolver;

@Entity
@Table(name = "OCRD")
@JsonIdentityInfo(
		property = "id",
		generator = ObjectIdGenerators.PropertyGenerator.class,
		resolver = EntityIdResolver.class,
		scope=BusinessPartner.class)
@JsonIdentityReference(alwaysAsId = true)
public class BusinessPartner 
{
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
	@Column
	String name;
}
