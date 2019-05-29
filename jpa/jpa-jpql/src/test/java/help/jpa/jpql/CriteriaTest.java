package help.jpa.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CriteriaTest {

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void testQuery() throws Exception {
		EntityManager em = entityManager.getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Country> q = cb.createQuery(Country.class);
		Root<Country> c = q.from(Country.class);
		List<Country> results = em.createQuery(q).getResultList();	
		System.out.println(results.size());

	}
	@Test
	public void testQueryNew() throws Exception {
//		EntityManager em = entityManager.getEntityManager();
	//	TypedQuery<CountryNew> query = em.createQuery("SELECT NEW help.jpa.jpql.CountryNew(c.id) FROM Country c", CountryNew.class);
		//List<CountryNew> results = query.getResultList();
		//System.out.println(results.size());
		EntityManager em = entityManager.getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Tuple> q = cb.createTupleQuery();
		Root<Country> c = q.from(Country.class);
		q.select(cb.tuple(c.get("name"), c.get("capital").get("name")));
		List<Tuple> results = em.createQuery(q).getResultList();
		for (Tuple t : results) {
		     System.out.println("Country: " + t.get(0)  + ", Capital: " + t.get(1));
		}
	}	
}