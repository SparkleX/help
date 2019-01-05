package help.model;

import java.math.BigDecimal;
import java.util.ArrayList;
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

import help.EntityIdResolver;

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
	@Column(name="Id")
	Integer id;
	
	
	@Column(name="DocTotal")
	BigDecimal docTotal;
	
	@ManyToOne(optional = false,fetch=FetchType.EAGER)
	@JoinColumn(name="BusinessPartnerId",insertable = false, updatable = false)	
	BusinessPartner businessPartner;
	

	@Column(name = "BusinessPartnerId")
	Integer businessPartnerId;

	public Collection<SalesOrderDetail> getDetails() {
		return details;
	}

	public void setDetails(Collection<SalesOrderDetail> details) {
		this.details = details;
	}

	@OneToMany(mappedBy="doc",fetch = FetchType.LAZY, cascade= CascadeType.ALL)
	Collection<SalesOrderDetail> details = new ArrayList<>();
	

	@PrePersist
	private void prePersist() 
	{
		System.out.print("prePersist");
		//details.forEach( c -> c.setDocId(this));
	}
}
