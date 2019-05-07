package help.jpa.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import help.jpa.rest.model.SalesOrder;

public interface RepoSalesOrder extends JpaRepository<SalesOrder, Integer> 
{


}
