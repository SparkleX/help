package help.jpa.mapping;

import javax.persistence.EntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@DataJpaTest
@SuppressWarnings("unused")
public class MappingTest
{
	@Autowired
	EntityManager em;


	@Test
	public void test() throws Exception
	{
		OrderTax oOrderTax = em.find(OrderTax.class, 1);
		Order oOrder = oOrderTax.getOrder();
		em.flush();
	}

	@Test
	public void mapperByTest() throws Exception
	{
		Order oOrder = em.find(Order.class, 1);
		OrderTax oOrderTax = oOrder.getTax();
		em.flush();
	}
	
	@Test
	public void jsonTest() throws Exception
	{
		Order oOrder = em.find(Order.class, 1);
		OrderTax oOrderTax = oOrder.getTax();
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(oOrder);
		System.out.println(json);
		em.flush();
	}
}