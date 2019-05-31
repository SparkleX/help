package help.jpa.jpql;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EmbeddableType;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CriteriaMetaModel {

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void testQuery() throws Exception {
		EntityManager em = entityManager.getEntityManager();
		Metamodel mm = em.getMetamodel();
		 Set<EntityType<?>> et = mm.getEntities();
		for(EntityType<?> e:et)
		{
			System.out.println(e.getName());
		}

	}
	
}