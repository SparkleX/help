package querydsl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.jpa.impl.JPAQuery;

import entity.BusinessPartner;
import entity.QBusinessPartner;

@RestController
public class RestService 
{
	@PersistenceContext
	EntityManager em;
	
	@GetMapping("/test")
	public List<BusinessPartner> test()
	{
		JPAQuery<BusinessPartner> query = new JPAQuery<> (em);
		QBusinessPartner businessPartner = QBusinessPartner.businessPartner;
		List<BusinessPartner> bps = query
				.from(businessPartner)
				.where(businessPartner.cardCode.containsIgnoreCase("C")).fetch();
		return bps;
		
	}
	@Autowired
	DataSource dataSource;
}
