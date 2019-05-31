package help.jackson.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

public class Bean 
{
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	@JsonView({Views.A.class, Views.B.class})
	@JsonProperty("a")
	String a;
	@JsonView({Views.B.class})
	@JsonProperty("b")
	String b;
}
