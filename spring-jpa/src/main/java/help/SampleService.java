package help;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleService 
{
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	RepoCustomer daoCustomer;

	public List<Customer> find(Integer id) 
	{
		Customer entity = daoCustomer.findById(1).get();
		em.lock(entity, LockModeType.PESSIMISTIC_READ);
		entity.setName("fe");
		daoCustomer.save(entity);
		return daoCustomer.findAll();
		
		//return null;
	}

}
