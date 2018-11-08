package help;

import com.github.dozermapper.core.Mapping;

public class LineA 
{
	public Integer getLineNum() {
		return lineNum;
	}

	public void setLineNum(Integer lineNum) {
		this.lineNum = lineNum;
	}
	@Mapping("row")
	Integer lineNum;
}
