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
public class MappingTest
{
	@Autowired
	EntityManager em;

	@Test
	public void test() throws Exception
	{
		Order order = em.find(Order.class, 1);
		order.getDetail().size();
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(order);
		System.out.println(json);
		System.out.println(order.getDetail().get(1).getOrder().getMemo());
		em.flush();
	}
	
}