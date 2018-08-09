package help;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class TestComponent 
{
    @HystrixCommand(fallbackMethod = "defaultDiscount")
    public BigDecimal getDiscount(String itemCode) throws Exception 
    {
    	//Thread.sleep(2000);
    	System.out.println("getDiscount:" + itemCode);
    	return BigDecimal.valueOf(0.10);
    }

    public BigDecimal defaultDiscount(String itemCode) 
    {
    	System.out.println("defaultDiscount:" + itemCode);
    	return BigDecimal.ZERO;
    }
}