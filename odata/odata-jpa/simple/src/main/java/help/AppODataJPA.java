package help;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;

import help.model.Item;

@SpringBootApplication
@ServletComponentScan("tutorial")
@EntityScan("help")
public class AppODataJPA
{
	static public void main(String[]argc)
	{
	/*	EntityManagerFactory emf = Persistence.createEntityManagerFactory( "test" );
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist( new Item() );
		em.getTransaction().commit();
		em.close();*/
		SpringApplication.run(AppODataJPA.class, argc);
	}
}
