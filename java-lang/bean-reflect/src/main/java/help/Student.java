package help;

public class Student 
{
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public Boolean getMale() {
		return male;
	}
	public void setMale(Boolean male) {
		this.male = male;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	String ID;
	Boolean male;
	String firstName;
	String lastName;
}
