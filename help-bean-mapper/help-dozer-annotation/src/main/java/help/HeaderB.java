package help;

import java.util.HashMap;
public class HeaderB 
{

	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	Integer uid;
	String fullname;
	

	public HashMap<String, Object> getRows() {
		return rows;
	}
	public void setRows(HashMap<String, Object> rows) {
		this.rows = rows;
	}
	HashMap<String,Object> rows;
}
