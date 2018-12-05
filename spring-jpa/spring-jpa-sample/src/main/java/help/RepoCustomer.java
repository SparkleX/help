package help;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepoCustomer extends JpaRepository<Customer, Integer> 
{
    @Query(value="select * from Customer where id = :id",nativeQuery=true)
    public List<Customer> nativeFindAll(@Param("id") Integer id);
}
