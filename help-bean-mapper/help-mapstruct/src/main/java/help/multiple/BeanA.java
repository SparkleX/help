package help.multiple;

public class BeanA
{
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BeanAAddress getAddress() {
		return address;
	}
	public void setAddress(BeanAAddress address) {
		this.address = address;
	}
	public BeanATax getTax() {
		return tax;
	}
	public void setTax(BeanATax tax) {
		this.tax = tax;
	}
	public Integer id;
	public BeanAAddress address;
	public BeanATax tax;
}
