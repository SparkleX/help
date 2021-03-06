package help;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Application 
{
	@SuppressWarnings("unused")
	public static void main(String []argc)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "test.jpa" );
		EntityManager em1 = entityManagerFactory.createEntityManager();
		EntityManager em2 = entityManagerFactory.createEntityManager();

		boolean open = em1.isOpen();
		open = em1.isOpen();
		EntityTransaction t1 = em1.getTransaction();
		t1.begin();
		t1.commit();
		EntityTransaction t2 = em1.getTransaction();
		EntityTransaction t3 = em2.getTransaction();
		EntityTransaction t4 = em2.getTransaction();
		
		em1.close();
		entityManagerFactory.close();
	}
}
