package help;

import java.util.List;

import com.github.dozermapper.core.Mapping;

public class HeaderA 
{
	public Integer getId() 
	{
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Mapping("uid")
	Integer id;
	@Mapping("fullname")
	String name;
	
	public List<LineA> getLines() {
		return lines;
	}
	public void setLines(List<LineA> lines) {
		this.lines = lines;
	}
	@Mapping("rows")
	List<LineA> lines;
}
