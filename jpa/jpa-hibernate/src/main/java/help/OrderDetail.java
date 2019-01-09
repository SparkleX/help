package help;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "RDR1")
@IdClass(OrderDetailKey.class)
public class OrderDetail
{
	@Id
	Integer id;
	
	@Id
	Integer lineNum;
	
	@Column
	String note;

}
