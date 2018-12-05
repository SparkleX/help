package help.jpa;

import javax.persistence.Parameter;

public class QuickParameter implements Parameter {

	private String name;

	public QuickParameter(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Integer getPosition() {
		return 0;
	}

	@Override
	public Class getParameterType() {
		return String.class;
	}

}
