package help.redis.spring.cache;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.redis.core.RedisHash;

//@RedisHash("persons")
@Entity
class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3638165710411665278L;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	//@Id
	@Id
	String id;
	@Column
	String data;

}