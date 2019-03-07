package nosql.cassandra.spring;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("emp")
public class Employee 
{
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@PrimaryKeyColumn(
      name = "emp_id", 
      ordinal = 2, 
      type = PrimaryKeyType.PARTITIONED, 
      ordering = Ordering.DESCENDING)
    Integer id;
    
    @Column("emp_city")
    String city;
    
}
