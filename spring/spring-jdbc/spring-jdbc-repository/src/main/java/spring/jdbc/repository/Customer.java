package spring.jdbc.repository;

import org.springframework.data.domain.Persistable;

public class Customer implements Persistable<String> 
{
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	String name;

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}
}
