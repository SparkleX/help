package help.jpa.mapping;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
public class MappingTest
{
	@Autowired
	EntityManager em;


	@Test
	public void test() throws Exception
	{
		Order oOrder = em.find(Order.class, 1);
		System.out.println(oOrder.getDetail().size());
		System.out.println(oOrder.getDetail().get(0).getLineNum());
		em.flush();
	}
	

}