package help;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import help.repo.RepoItem;

@SpringBootApplication
@RestController
public class AppJpaUserFields 
{
	@Autowired
	RepoItem repoItem;
	
	@PersistenceContext
	EntityManager em;
	
	public static void main(String []argc)
	{
		SpringApplication.run(AppJpaUserFields.class, argc);
	}
	
	@Transactional
	@GetMapping(path="/test")
	public Object test()
	{
		//Query query = em.createQuery("select sum(0+ t0.userFields.user000) from Item t0");
		//List data = query.getResultList();
		//return data;
		return repoItem.sumInteger();	
		//return repoItem.countInteger();
	}
	
	@Transactional
	@GetMapping(path="/testFloat")
	public Object testFloat()
	{
		return repoItem.sumFloat();	
	}
	
	@Transactional
	@GetMapping(path="/testFunction")
	public Object testFunction()
	{
		return repoItem.sumFunction();	
	}
}
