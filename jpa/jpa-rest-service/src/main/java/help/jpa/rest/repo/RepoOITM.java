package help.jpa.rest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import help.jpa.rest.model.Item;



public interface RepoOITM extends Repository<Item, String> 
{
	@Query(nativeQuery = true, value="select * from OITM where ItemCode=1")
	List<Item> search();
	
	@Query(nativeQuery = true, value="select * from OITM where ItemCode=? and l=?")
	List<Item> search2(String itemCode, Integer a);
	
	@Query(nativeQuery = true, value="select * from OITM where ItemCode=:a and l=:itemCode")
	List<Item> search3(@Param("itemCode")String itemCode, @Param("a") Integer a);
}