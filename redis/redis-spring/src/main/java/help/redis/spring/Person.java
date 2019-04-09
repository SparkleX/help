package help.redis.spring;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash("persons")
class Person {

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Person> getChildren() {
		return children;
	}

	public void setChildren(List<Person> children) {
		this.children = children;
	}
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	@Id
	String id;

	@Indexed
	String firstname;
	@Indexed
	String lastname;



	String data;
	// Gender gender;
	// Address address;

	@Reference
	List<Person> children;
}