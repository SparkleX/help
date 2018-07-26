package help.spring.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SampleService 
{

	@Autowired
	JdbcTemplate jdbcTemplate;
	public String get(int id) 
	{
		String sql = "SELECT * FROM CUSTOMER WHERE ID = ?";
		List<Customer> customer = jdbcTemplate.query(sql, new Object[] { id },new BeanPropertyRowMapper(Customer.class));
	    return customer.get(0).getName();
	}

}
