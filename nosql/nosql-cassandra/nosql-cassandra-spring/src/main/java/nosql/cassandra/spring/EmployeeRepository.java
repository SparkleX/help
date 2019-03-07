package nosql.cassandra.spring;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CassandraRepository<Employee,Integer> 
{
	@Query("SELECT * FROM emp WHERE emp_id>?0 ALLOW FILTERING")
	public List<Employee> findTest(Integer empId);
	
}