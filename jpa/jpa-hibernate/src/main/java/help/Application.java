package help;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application 
{
	@SuppressWarnings("unused")
	public static void main(String []argc)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "test.jpa" );
		EntityManager em1 = entityManagerFactory.createEntityManager();
		
		em1.getTransaction().begin();
		OrderDetail oOrderDetail = new OrderDetail();
		oOrderDetail.id = 1;
		oOrderDetail.lineNum = 2;				
		em1.persist(oOrderDetail);
		em1.getTransaction().commit();
		
		em1.getTransaction().begin();
		OrderDetailKey oKey = new OrderDetailKey();
		oKey.setId(1);
		oKey.setLineNum(4);
		oOrderDetail = em1.find(OrderDetail.class, oKey);
		
		em1.getTransaction().commit();
		
		entityManagerFactory.close();
	}
}
