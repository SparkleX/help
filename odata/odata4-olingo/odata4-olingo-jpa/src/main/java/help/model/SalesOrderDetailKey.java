package help.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class SalesOrderDetailKey implements Serializable
{

	private static final long serialVersionUID = 8983163918014864608L;
	public int  getDocId() {
		return docId;
	}
	public void setDocId(Integer  docId) {
		this.docId = docId;
	}
	public int getLineNum() {
		return lineNum;
	}
	public void setLineNum(Integer lineNum) {
		this.lineNum = lineNum;
	}
	//SalesOrder docId;
	@Id
	@Column(name="DocId")
	Integer docId;
	@Id
	@Column(name="LineNum")
	Integer lineNum;
}
