package help;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import help.model.BusinessPartner;
import help.model.Item;
import help.model.SalesOrder;
import help.repo.RepoOITM;
import help.repo.RepoSalesOrder;

@Service
public class OrderService 
{
	@Autowired
	RepoOITM repoOITM;
	
	@Transactional
	public List<SalesOrder> test()
	{
		return repoSalesOrder.findAll();
	}
	
	@Autowired
	EntityManager em;
	
	@Autowired
	RepoSalesOrder repoSalesOrder;
	
	@Transactional
	public String init()
	{
		BusinessPartner oBP = new BusinessPartner();
		oBP.setName("C001");
		em.persist(oBP);
		
		Item oItem = new Item();
		oItem.setItemCode("I001");
		em.persist(oItem);
		
		SalesOrder oOrder = new SalesOrder();
		oOrder.setBusinessPartner(oBP);
		em.persist(oOrder);
		
		return "done";
	}
}
