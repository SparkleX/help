package help.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "RDR1")
@IdClass(SalesOrderDetailKey.class)
public class SalesOrderDetail 
{
	@Id
	Integer docId;
	
	@Id
	Integer lineNum;
	
	@Column
	Integer itemId;
	
	@Column
	BigDecimal price;
	
}
