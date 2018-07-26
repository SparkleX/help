package help.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SampleService 
{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public void add() throws Exception 
	{
		jdbcTemplate.execute("insert into customer(id,name) values(1,'a')");
		//jdbcTemplate.execute("insert into customer(id,name) values(5,'e')");
		throw new Exception("failed");
	//	throw new RuntimeException("failed");
	}

}
