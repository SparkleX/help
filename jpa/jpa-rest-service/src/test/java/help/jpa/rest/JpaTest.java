package help.jpa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.test.context.junit4.SpringRunner;

import help.jpa.rest.model.BusinessPartner;
import help.jpa.rest.model.Item;
import help.jpa.rest.model.SalesOrder;
import help.jpa.rest.repo.RepoSalesOrder;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private RepoSalesOrder repository;

	@Test
	public void testExample() throws Exception {
		Optional<SalesOrder> user = this.repository.findById(1);
		assertThat(user.isPresent()).isEqualTo(false);
	}
	@Test
	public void testQuery() throws Exception {
		EntityManager em = entityManager.getEntityManager();
		List<Item> items = em.createQuery("from Item i where i.itemCode='1'").getResultList();
		System.out.println(items.size());
		
	}
}