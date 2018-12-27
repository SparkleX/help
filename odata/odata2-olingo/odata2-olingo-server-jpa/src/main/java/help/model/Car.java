package help.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Car")
public class Car {

	@EmbeddedId
	private Key key;

	@Column
	private String model;
	@Column
	private Double price;
	@Column
	private Integer modelYear;
	@Temporal(TemporalType.DATE)
	private Date updated;

	public Car() {

	}

	public Car(Key key, String model, Double price, Integer modelYear,
			Date updated, Manufacturer manufacturer, Driver driver) {
		super();
		this.key = key;
		this.model = model;
		this.price = price;
		this.modelYear = modelYear;
		this.updated = updated;
		this.manufacturer = manufacturer;
		this.driver = driver;
	}

	@ManyToOne
	@JoinColumn(name = "MID", referencedColumnName = "ID")
	private Manufacturer manufacturer;

	@OneToOne
	private Driver driver;

	public Key getKey() {
		return key;
	}

	public void setKey(Key id) {
		this.key = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}
}