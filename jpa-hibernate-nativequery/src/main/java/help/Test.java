package help;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test
{

	public static void main(String[] args)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-name");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();

		Customer oCustomer = entityManager.getReference(Customer.class, 1);
		entityManager.remove(oCustomer);
		oCustomer = new Customer(1,"100");
		entityManager.persist(oCustomer);
		
		oCustomer = entityManager.getReference(Customer.class, 1);
		
		List<Customer> rows = entityManager.createQuery("SELECT t FROM Customer t WHERE t.id = 1", Customer.class).getResultList();
		//List<Customer> rows = entityManager.createNativeQuery("select * from Customer where id = 1", Customer.class).getResultList();
	    for (Customer row : rows) 
	    {  
	        System.out.println("id = " + row.getId());  
 
	    }  
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}

}
