package help.jpa;

import javax.persistence.Parameter;

@SuppressWarnings("rawtypes")
public class QuickParameter implements Parameter {

	private String name;
	private Integer position;

	public QuickParameter(String name, int position)
	{
		this.name = name;
		this.position = position;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Integer getPosition() {
		return position;
	}

	@Override
	public Class getParameterType() {
		return String.class;
	}

}
