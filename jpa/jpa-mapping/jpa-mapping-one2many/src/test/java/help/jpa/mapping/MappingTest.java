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
		Order oOrder = em.find(Order.class, 1);
		oOrder.getDetail().size();
		em.flush();
	}
	
	@Test
	public void detailTest() throws Exception
	{
		OrderDetailKey key = new OrderDetailKey();
		key.setLineNum(1);
		Order order = new Order();
		order.setId(1);
		key.setOrder(order);
		OrderDetail oOrderDetail = em.find(OrderDetail.class, key);
		Order order2 = oOrderDetail.getOrder();
		System.out.println(order2.getMemo());
		em.flush();
	}
	@Test
	public void detailTest3() throws Exception
	{
		Order order = em.find(Order.class, 1);		
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setLineNum(3);
		orderDetail.setOrder(order);
		em.persist(orderDetail);
		Order order2 = orderDetail.getOrder();
		System.out.println(order2.getMemo());
		em.flush();
	}
	@Test
	public void jsonTest() throws Exception
	{
		Order oOrder = em.find(Order.class, 1);
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(oOrder);
		System.out.println(json);
		em.flush();
	}	
	@Test
	public void persistTest() throws Exception
	{
		Order order = new Order();
		order.setId(100);
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setLineNum(1);
		orderDetail.setOrder(order);
		order.getDetail().add(orderDetail);
		em.persist(order);
		em.flush();
	}
}