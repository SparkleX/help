package tutorial.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import help.model.OCRD;

@RestController
public class TestRestController
{
	@Autowired
	InitService service;
	
	@RequestMapping("/init")
	String test()
	{
		service.test();
		return "ok";
	}
}
