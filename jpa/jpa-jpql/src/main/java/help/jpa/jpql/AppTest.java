package help.jpa.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
@EntityScan
public class AppTest {

	public static void main(String[] args) {
		ConfigurableApplicationContext appContext = SpringApplication.run(AppTest.class, args);
		appContext.getBean(AppTest.class).test();
	}

	@Autowired
	EntityManager em;
	private void test() {
	  TypedQuery<Country> query =
		      em.createQuery("SELECT c FROM Country c", Country.class);
		  List<Country> results = query.getResultList();
	}

}
