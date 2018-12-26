package help.model;

import java.io.Serializable;

public class OrderDetailsKey implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1475627748351284529L;
	private Integer docEntry;
	private Integer lineNum;

	public OrderDetailsKey(Integer docEntry, Integer lineNum)
	{
		this.docEntry = docEntry;
		this.lineNum = lineNum;
	}

	public boolean equals(Object object)
	{
		if (object instanceof OrderDetailsKey)
		{
			OrderDetailsKey pk = (OrderDetailsKey) object;
			return docEntry.equals(pk.docEntry) && lineNum.equals(pk.lineNum);
		} else
		{
			return false;
		}
	}

	public int hashCode()
	{
		return docEntry.hashCode() + lineNum;
	}
}
