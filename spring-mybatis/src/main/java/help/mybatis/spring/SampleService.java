package help.mybatis.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleService 
{
	@Autowired
	 private DaoCustomer customerMapper;

	  
	public List<Customer> get() 
	{
		List<Customer> list = customerMapper.findAll();
		return list;
	}

}
