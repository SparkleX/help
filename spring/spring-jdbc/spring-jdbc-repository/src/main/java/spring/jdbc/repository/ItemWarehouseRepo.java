package spring.jdbc.repository;

import org.springframework.data.repository.CrudRepository;

import spring.jdbc.repository.domain.ItemWarehouse;

public interface ItemWarehouseRepo extends CrudRepository<ItemWarehouse,String> 
{

}
