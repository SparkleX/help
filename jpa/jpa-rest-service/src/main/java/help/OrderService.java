package help;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public SalesOrder test()
	{
		try
		{
			Optional<SalesOrder> list = repoSalesOrder.findById(1);
			if(list.isPresent())
			{
				System.out.println("123");
				return list.get();
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		return null;
		
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
	@Transactional
	public String create(SalesOrder data) 
	{
	/*	for(SalesOrderDetail orderDetail:data.getDetails())
		{
			orderDetail.setDocId(data);
		}*/
		em.persist(data);
		return "done";
	}
}
