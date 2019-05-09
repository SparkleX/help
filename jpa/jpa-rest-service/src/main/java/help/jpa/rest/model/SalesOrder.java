package help.jpa.rest.model;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import help.jpa.rest.EntityIdResolver;

@Entity
@Table(name = "ORDR")
@JsonIdentityInfo(
		property = "id",
		generator = ObjectIdGenerators.PropertyGenerator.class,
		resolver = EntityIdResolver.class,
		scope=SalesOrder.class)
public class SalesOrder 
{
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

/*	public Integer getBusinessPartnerId() {
		return businessPartnerId;
	}

	public void setBusinessPartnerId(Integer businessPartnerId) {
		this.businessPartnerId = businessPartnerId;
	}*/

	public BigDecimal getDocTotal() {
		return docTotal;
	}

	public void setDocTotal(BigDecimal docTotal) {
		this.docTotal = docTotal;
	}
	
	public BusinessPartner getBusinessPartner() {
		return businessPartner;
	}

	public void setBusinessPartner(BusinessPartner businessPartner) {
		this.businessPartner = businessPartner;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
//	@Column
//	Integer businessPartnerId;
	
	@Column
	BigDecimal docTotal;
	
	@ManyToOne(fetch=FetchType.EAGER)
	//@MapsId("business_partner_id")
	@JoinColumn(name="businessPartnerId")
//	@Transient

	
	BusinessPartner businessPartner;
	
	


	public Collection<SalesOrderDetail> getDetails() {
		return details;
	}

	public void setDetails(Collection<SalesOrderDetail> details) {
		this.details = details;
	}

	@OneToMany(mappedBy="docId",cascade= CascadeType.ALL)
	//@JoinColumn(name="doc_id")
	//@NotNull
	Collection<SalesOrderDetail> details;
	

	@PrePersist
	private void prePersist() 
	{
		System.out.print("prePersist");
		details.forEach( c -> c.setDocId(this));
	}
}
