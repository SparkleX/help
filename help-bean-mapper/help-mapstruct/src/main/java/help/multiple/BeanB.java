package help.multiple;

import java.util.List;

public class BeanB
{
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<BeanBLine> getLines() {
		return lines;
	}
	public void setLines(List<BeanBLine> lines) {
		this.lines = lines;
	}
	public Integer id;
	public List<BeanBLine> lines;
}
