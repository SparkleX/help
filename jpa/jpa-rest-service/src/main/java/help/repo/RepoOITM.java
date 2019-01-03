package help.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import help.model.MoOITM;



public interface RepoOITM extends Repository<MoOITM, String> 
{
	@Query(nativeQuery = true, value="select * from OITM where ItemCode=1")
	List<MoOITM> search();
	
	@Query(nativeQuery = true, value="select * from OITM where ItemCode=? and l=?")
	List<MoOITM> search2(String itemCode, Integer a);
	
	@Query(nativeQuery = true, value="select * from OITM where ItemCode=:a and l=:itemCode")
	List<MoOITM> search3(@Param("itemCode")String itemCode, @Param("a") Integer a);
}