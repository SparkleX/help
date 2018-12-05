package mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import entity.a.EnumOrderStatus;
import entity.a.OrderA;
import entity.b.EnumYesNo;
import entity.b.OrderB;
@SpringBootTest
@ContextConfiguration(classes=TestConfig.class)
@RunWith(SpringRunner.class)
public class MapperEnumTest 
{
	@Autowired
    private OrderMapper orderMapper;
	
	@Test
    public void say() 
	{
		OrderA orderA = new OrderA();
		orderA.setStatus(EnumOrderStatus.C);
		OrderB orderB = orderMapper.toB(orderA );
		assertEquals("Order is closed", EnumYesNo.Y, orderB.getClosed());
    }
}
