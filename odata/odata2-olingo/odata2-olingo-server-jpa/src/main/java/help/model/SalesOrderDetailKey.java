package help.model;

import java.io.Serializable;

public class SalesOrderDetailKey implements Serializable
{

	private static final long serialVersionUID = 8983163918014864608L;
	public SalesOrder getDocId() {
		return docId;
	}
	public void setDocId(SalesOrder docId) {
		this.docId = docId;
	}
	public int getLineNum() {
		return lineNum;
	}
	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}
	SalesOrder docId;
	int lineNum;
}
