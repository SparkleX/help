package help.jpa.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpqlTest {

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void testQuery() throws Exception {
		EntityManager em = entityManager.getEntityManager();
		TypedQuery<Country> query = em.createQuery("SELECT c FROM Country c", Country.class);
		List<Country> results = query.getResultList();
		System.out.println(results.size());
	}
	@Test
	public void testQueryNew() throws Exception {
		EntityManager em = entityManager.getEntityManager();
		TypedQuery<CountryNew> query = em.createQuery("SELECT NEW help.jpa.jpql.CountryNew(c.id) FROM Country c", CountryNew.class);
		List<CountryNew> results = query.getResultList();
		System.out.println(results.size());
	}	
}