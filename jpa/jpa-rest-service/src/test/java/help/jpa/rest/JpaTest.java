package help.jpa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.test.context.junit4.SpringRunner;

import help.jpa.rest.model.SalesOrder;
import help.jpa.rest.repo.RepoSalesOrder;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaTest {

	@Autowired
	private TestEntityManager em;

	@Autowired
	private RepoSalesOrder repository;

	@Test
	public void testExample() throws Exception {
		Optional<SalesOrder> user = this.repository.findById(1);
		assertThat(user.isPresent()).isEqualTo(false);
	}

}