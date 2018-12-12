package help;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import help.model.MoOITM;
import help.repo.RepoOITM;

@RestController
public class TestService 
{
	@Autowired
	RepoOITM repoOITM;
	
	@Transactional
	@GetMapping(path="/test")
	public List<MoOITM> test()
	{
		return repoOITM.search3("I001",100);
	}
}
