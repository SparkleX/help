package help.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import help.model.Item;



public interface RepoItem extends Repository<Item, Integer> 
{
	
	@Query("select sum(0+ t0.userFields.user000) from Item t0")
	Integer sumInteger();
	@Query("select sum(0.0+ t0.userFields.user001) from Item t0")
	Float sumFloat();

	
	@Query("select sum(0 + FUNCTION('abs',t0.userFields.user002)) from Item t0")
	Integer sumFunction();

}