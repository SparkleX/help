package help;

import java.math.BigDecimal;

public class Bean 
{
	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	protected BigDecimal total;
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	protected BigDecimal price;
	
}
