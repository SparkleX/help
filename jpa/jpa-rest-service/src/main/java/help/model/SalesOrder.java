package help.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "ORDR")
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
	
	@ManyToOne(fetch=FetchType.LAZY)
	//@MapsId("business_partner_id")
	@JoinColumn(name="business_partner_id")
//	@Transient

	@JsonIdentityReference(alwaysAsId = true)
	BusinessPartner businessPartner;
	
}
