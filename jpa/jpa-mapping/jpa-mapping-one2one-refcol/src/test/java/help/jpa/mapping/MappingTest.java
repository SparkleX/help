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
		OrderTax orderTax = em.find(OrderTax.class, 101);
		Order order2 = orderTax.getOrder();
		System.out.println(order2.getId());
		em.flush();
	}

}