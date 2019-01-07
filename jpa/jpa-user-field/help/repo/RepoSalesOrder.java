package help.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import help.model.SalesOrder;

public interface RepoSalesOrder extends JpaRepository<SalesOrder, Integer> 
{


}
