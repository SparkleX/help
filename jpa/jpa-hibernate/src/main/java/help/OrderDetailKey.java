package help;

import java.io.Serializable;
import java.util.Objects;

public class OrderDetailKey implements Serializable
{
	private static final long serialVersionUID = 6206157117831997633L;
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getLineNum()
	{
		return lineNum;
	}
	public void setLineNum(Integer lineNum)
	{
		this.lineNum = lineNum;
	}
	Integer id;
	Integer lineNum;
	
	@Override
	public int hashCode()
	{
		return id;
		
	}
	@Override
	public boolean equals(Object o)
	{
        if (this == o) return true;
        if (!(o instanceof OrderDetailKey)) return false;
        OrderDetailKey object = (OrderDetailKey) o;
        return getId() != null && Objects.equals(getId(), object.getId());
		
	}
}
