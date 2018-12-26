package help.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "BusinessPartner")
@Table(name = "\"BusinessPartner\"")
public class BusinessPartner implements Serializable 
{

	@Id
	@Column(name = "\"BusinessPartnerID\"")
	private String businessPartnerID;
	  
	@Column(name = "\"CustomNum2\"", precision = 30, scale = 5)
	private BigDecimal customNum2;

	@OneToMany(mappedBy = "businessPartner", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private Collection<BusinessPartnerRole> roles;

	public BusinessPartner() {
		super();
	}
}