package help;

import java.io.Serializable;

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
}
