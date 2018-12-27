package help.model;


import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Driver")
public class Driver {

	public void setId(Long id)
	{
		this.id = id;
	}

	@Id
	private Long id;

	@Column
	private String name;
	@Column
	private String lastname;
	@Column
	private String nickname;

	@OneToOne(mappedBy = "driver", cascade = CascadeType.ALL)
	private Car car;

	@Temporal(TemporalType.DATE)
	private Calendar birthday;

	public Driver() {

	}

	public Driver(Long id, String name, String lastname, String nickname,
			Car car, Calendar birthday) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.nickname = nickname;
		this.car = car;
		this.birthday = birthday;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Calendar getUpdated() {
		return birthday;
	}

	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

	public Calendar getBirthday() {
		return this.birthday;
	}
}