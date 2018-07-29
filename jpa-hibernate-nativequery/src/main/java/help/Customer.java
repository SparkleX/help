package help;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer
{
	public Customer()
	{
		
	}
	public Customer(int id, String name)
	{
		this.id = id;
		this.name = name;

	}
	@Id
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	@Column
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	Integer id;
	String name;
}
