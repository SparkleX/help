package help;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Application 
{
	public static void main(String []argc)
	{
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "test.jpa");
		doOnTentant(entityManagerFactory, "T1.dbo");
		doOnTentant(entityManagerFactory, "T2.dbo");
		entityManagerFactory.close();
	}

	private static void doOnTentant(EntityManagerFactory entityManagerFactory, String tentant) 
	{
		Map<String, Object> emProperties = new HashMap<String, Object>();
		emProperties.put("eclipselink.tenant-id", tentant);
		EntityManager em = entityManagerFactory.createEntityManager(emProperties);
		EntityTransaction t1 = em.getTransaction();
		t1.begin();
		User oUser = new User();
		oUser.setFullname("test");
		em.persist(oUser);
		
		List<User> list = em.createQuery("SELECT t FROM User t", User.class).getResultList();
		for(User oUser1:list)
		{
			System.out.println(oUser1.getFullname());
		}
		
		//List list2 = em.createNativeQuery("select * from USERS").getResultList();
		//System.out.println(list2.size());
		t1.commit();
		
		em.close();
		
	}
}
