package help.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 */

@Entity(name = "Manufacturer")
public class Manufacturer {

	@Id
	@Column(name = "ID")
	private int id;

	@Column
	private String name;
	@Temporal(TemporalType.DATE)
	private Calendar founded;
	@Embedded
	private Address address;

	public Manufacturer() {

	}

	public Manufacturer(int id, String name, Calendar founded, Address address,
			List<Car> cars) {
		super();
		this.id = id;
		this.name = name;
		this.founded = founded;
		this.address = address;
		this.cars = cars;
	}

	@OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL)
	private List<Car> cars = new ArrayList<Car>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getFounded() {
		return founded;
	}

	public void setFounded(Calendar updated) {
		this.founded = updated;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

}